package org.scoula.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.scoula.domain.ChatMessage;
import org.scoula.domain.GreetingMessage;
import org.scoula.service.ChatRoomService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
@Log4j2
// 브로커의 역할 일부 - 중계
public class ChatController {

    private final ChatRoomService chatRoomService;
    private final SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/chat.join")
    public void join(ChatMessage message, SimpMessageHeaderAccessor headerAccessor) {
        String sessionId = headerAccessor.getSessionId();
        ChatMessage enterMessage = chatRoomService.enter(sessionId, message.getRoomId(), message.getSender());
        String roomId = enterMessage.getRoomId();

        messagingTemplate.convertAndSend("/topic/rooms/" + roomId + "/messages", enterMessage);
        messagingTemplate.convertAndSend("/topic/rooms/" + roomId + "/users", chatRoomService.getUserListMessage(roomId));
    }


    @MessageMapping("/chat.send")
    public void send(ChatMessage message) {
        ChatMessage chatMessage = chatRoomService.createChatMessage(message);
        messagingTemplate.convertAndSend("/topic/rooms/" + chatMessage.getRoomId() + "/messages", chatMessage);
    }

    @MessageMapping("/chat.leave")
    public void leave(SimpMessageHeaderAccessor headerAccessor) {
        publishLeaveMessage(headerAccessor.getSessionId());
    }

    public void publishLeaveMessage(String sessionId) {
        ChatMessage leaveMessage = chatRoomService.leave(sessionId);
        if (leaveMessage == null) return;
        String roomId = leaveMessage.getRoomId();
        messagingTemplate.convertAndSend("/topic/rooms/" + roomId + "/messages", leaveMessage);
        messagingTemplate.convertAndSend("/topic/rooms/" + roomId + "/users", chatRoomService.getUserListMessage(roomId));
    }
}

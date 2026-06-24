package org.scoula.service;

import lombok.extern.log4j.Log4j2;
import org.scoula.domain.ChatMessage;
import org.scoula.domain.MessageType;
import org.scoula.domain.UserListMessage;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;


@Service
@Log4j2
public class ChatRoomService {

    private final Map<String, Set<String>> roomUsers = new ConcurrentHashMap<>();
    private final Map<String, String> sessionRoomMap = new ConcurrentHashMap<>();
    private final Map<String, String> sessionUserMap = new ConcurrentHashMap<>();

    public ChatMessage enter(String sessionId, String roomId, String sender) {
        String normalizedRoomId = normalizeRoomId(roomId);
        String normalizedSender = normalizeSender(sender);

        roomUsers.computeIfAbsent(normalizedRoomId, key -> Collections.synchronizedSet(new LinkedHashSet<>()))
                .add(normalizedSender);

        sessionRoomMap.put(sessionId, normalizedRoomId);
        sessionUserMap.put(sessionId, normalizedSender);

        return ChatMessage.builder()
                .roomId(normalizedRoomId)
                .sender(normalizedSender)
                .content(normalizedSender + "님이 입장했습니다.")
                .type(MessageType.ENTER)
                .sentAt(java.time.LocalDateTime.now().toString())
                .participantCount(getUserCount(normalizedRoomId))
                .build();
    }

    public ChatMessage createChatMessage(ChatMessage message) {
        String roomId = normalizeRoomId(message.getRoomId());
        String sender = normalizeSender(message.getSender());
        String content = message.getContent() == null ? "" : message.getContent().trim();

        return ChatMessage.builder()
                .roomId(roomId)
                .sender(sender)
                .content(content)
                .type(MessageType.CHAT)
                .sentAt(java.time.LocalDateTime.now().toString())
                .participantCount(getUserCount(roomId))
                .build();
    }

    public ChatMessage leave(String sessionId) {
        String roomId = sessionRoomMap.remove(sessionId);
        String sender = sessionUserMap.remove(sessionId);

        if (roomId == null || sender == null) {
            return null;
        }

        Set<String> users = roomUsers.get(roomId);
        if (users != null) {
            users.remove(sender);
            if (users.isEmpty()) {
                roomUsers.remove(roomId);
            }
        }

        return ChatMessage.builder()
                .roomId(roomId)
                .sender(sender)
                .content(sender + "님이 퇴장했습니다.")
                .type(MessageType.LEAVE)
                .sentAt(java.time.LocalDateTime.now().toString())
                .participantCount(getUserCount(roomId))
                .build();
    }

    public UserListMessage getUserListMessage(String roomId) {
        String normalizedRoomId = normalizeRoomId(roomId);
        List<String> users = new ArrayList<>(roomUsers.getOrDefault(normalizedRoomId, Collections.emptySet()));
        return UserListMessage.builder()
                .roomId(normalizedRoomId)
                .users(users)
                .count(users.size())
                .build();
    }

    private int getUserCount(String roomId) {
        return roomUsers.getOrDefault(roomId, Collections.emptySet()).size();
    }

    private String normalizeRoomId(String roomId) {
        return roomId == null || roomId.trim().isEmpty() ? "lobby" : roomId.trim();
    }

    private String normalizeSender(String sender) {
        return sender == null || sender.trim().isEmpty() ? "anonymous" : sender.trim();
    }
}

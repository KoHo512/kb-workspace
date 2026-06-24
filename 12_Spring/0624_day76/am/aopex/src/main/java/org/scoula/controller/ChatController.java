package org.scoula.controller;

import lombok.extern.log4j.Log4j2;
import org.scoula.domain.ChatMessage;
import org.scoula.domain.GreetingMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
@Log4j2
// 브로커의 역할 일부 - 중계
public class ChatController {

    @MessageMapping("/hello") // publisher가 전송하는 url (/app/hello)
    @SendTo("/topic/greetings") // 이 토픽을 구독한 subscriber에게 전달
    public GreetingMessage greeting(GreetingMessage message) throws Exception {
        log.info("greeting : " + message);
        return message;
    }

    @MessageMapping("/chat") // publisher가 /app/chat으로 메시지 전달
    @SendTo("/topic/chat") // 메세지를 /topic/chat의 매개변수로 전달 - 이 토픽을 구독한 subscriber에게
    public ChatMessage chat(ChatMessage message) throws Exception {
        log.info("chat received : " + message);
        return message;
    }
}

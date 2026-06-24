package org.scoula.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    // topic 정의
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        // 구독 시 사용할 토픽 접두어 - 이 토픽을 관리할 브로커 등록
        config.enableSimpleBroker("/topic");

        // 클라이언트가 발생시 사용해야 하는 접두어
        config.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // 접속 엔드포인트
        registry.addEndpoint("/chat-app")
                .setAllowedOrigins("*"); // CORS 허용
    }
}

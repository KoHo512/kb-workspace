package com.kdt.security3.config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * Spring Security의 DelegatingFilterProxy를 서블릿 컨테이너에 등록합니다.
 *
 * Spring Boot에서는 자동 등록되지만, 순수 Spring Framework WAR에서는
 * 이 초기화 클래스가 있어야 요청이 SecurityFilterChain을 통과합니다.
 */
public class SecurityWebApplicationInitializer
        extends AbstractSecurityWebApplicationInitializer {
    // 상속만으로 springSecurityFilterChain 필터가 등록됩니다.
}

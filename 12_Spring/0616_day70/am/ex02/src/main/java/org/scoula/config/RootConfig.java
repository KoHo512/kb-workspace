package org.scoula.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// Web, Servlet 제외한 설정 - 주로 DB 관련
@Configuration
@ComponentScan(basePackages = {"org.scoula"})
public class RootConfig {
}

package com.kdt.security3.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.FilterType;

/**
 * 웹 계층을 제외한 공통 빈을 탐색하는 루트 설정입니다.
 */
@Configuration
@ComponentScan(basePackages = "com.kdt.security3",
        excludeFilters = @ComponentScan.Filter(
                type = FilterType.ANNOTATION,
                classes = Configuration.class))
@PropertySource("classpath:application.properties")
public class RootConfig {
}

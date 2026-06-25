package com.kdt.security1.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.FilterType;

/**
 * 웹 계층을 제외한 공통 빈을 탐색하는 루트 설정입니다.
 *
 * "com.kdt.security1" 전체를 스캔하되,
 * @Configuration 클래스는 제외하고, application.properties를 읽도록 설정
 *
 * service 패키지, mapper/repository, domain, common/util 컴포넌트 스캔해서 빈(Bean) 등록
 */
@Configuration
@ComponentScan(basePackages = "com.kdt.security1",
        excludeFilters = @ComponentScan.Filter(
                type = FilterType.ANNOTATION,
                classes = Configuration.class))
@PropertySource("classpath:application.properties")
public class RootConfig {
}

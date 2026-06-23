package org.scoula.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * [학생용 TODO]
 * Spring MVC 설정 클래스입니다.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"org.scoula.controller", "org.scoula.board.controller"})
public class ServletConfig implements WebMvcConfigurer {

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // TODO 1
        // 일반 정적 리소스 /resources/** 매핑을 작성하세요.
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("/resources/");

        // TODO 2
        // Swagger UI 페이지 리소스를 매핑하세요.
        registry.addResourceHandler("/swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        // TODO 3
        // Swagger WebJar 리소스를 매핑하세요.
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");

        // TODO 4
        // Swagger 리소스와 API 문서 경로를 매핑하세요.
        registry.addResourceHandler("/swagger-resources/**")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/v2/api-docs")
                .addResourceLocations("classpath:/META-INF/resources/");
    }
}

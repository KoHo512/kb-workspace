package org.scoula.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * [학생용 TODO]
 * Swagger 문서 자동화 설정 클래스입니다.
 */
@Configuration
@EnableSwagger2 // TODO: Swagger 2 기능을 활성화하는 어노테이션입니다.
public class SwaggerConfig {

    private static final String API_NAME = "Board API";
    private static final String API_VERSION = "1.0";
    private static final String API_DESCRIPTION = "Spring MVC RestController + MyBatis + Swagger API 명세서";

    private ApiInfo apiInfo() {
        // TODO 1
        // ApiInfoBuilder를 이용하여 title, description, version을 설정하세요.
        return new ApiInfoBuilder()
                .title(API_NAME)
                .description(API_DESCRIPTION)
                .version(API_VERSION)
                .build();
    }

    @Bean
    public Docket api() {
        // TODO 2
        // Docket을 생성하고 @RestController가 붙은 클래스만 Swagger 문서 대상으로 설정하세요.
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }
}

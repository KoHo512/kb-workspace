package org.scoula.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * ServletConfig
 * -----------------------------------------------------------------------------
 * servlet-context.xml에 해당하는 DispatcherServlet 전용 설정입니다.
 *
 * 담당 영역
 * 1. Controller Bean 스캔
 * 2. JSP ViewResolver 설정
 * 3. 정적 리소스 매핑
 * 4. MultipartResolver 등록
 *
 * 파일 업로드에서 가장 중요한 Bean은 multipartResolver입니다.
 * Bean 이름이 반드시 "multipartResolver"여야 DispatcherServlet이 multipart 요청을
 * 자동으로 MultipartFile로 바인딩할 수 있습니다.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "org.scoula.board.controller")
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
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("/resources/");
    }

    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setDefaultEncoding("UTF-8");
        resolver.setMaxUploadSize(20L * 1024 * 1024); // 20MB
        resolver.setMaxUploadSizePerFile(10L * 1024 * 1024); // 10MB
        return resolver;
    }
}

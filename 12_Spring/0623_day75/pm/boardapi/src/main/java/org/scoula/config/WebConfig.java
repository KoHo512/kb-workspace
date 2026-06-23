package org.scoula.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * [학생용 TODO]
 * web.xml 없이 Java Config로 DispatcherServlet을 등록하는 클래스입니다.
 */
public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        // TODO 1
        // ServletConfig.class와 SwaggerConfig.class를 함께 등록하세요.
        // SwaggerConfig를 누락하면 /swagger-ui.html 접근 시 404가 발생할 수 있습니다.
        return new Class[]{ServletConfig.class, SwaggerConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        // TODO 2
        // DispatcherServlet 매핑과 Swagger 관련 URL 매핑을 작성하세요.
        return new String[]{
                "/",
                "/swagger-ui.html",
                "/swagger-resources/**",
                "/v2/api-docs",
                "/webjars/**"
        };
    }
}

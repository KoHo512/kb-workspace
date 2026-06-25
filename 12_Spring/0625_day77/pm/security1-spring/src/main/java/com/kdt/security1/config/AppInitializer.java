package com.kdt.security1.config;

import javax.servlet.Filter;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * web.xml을 대신하는 Servlet 3+ 초기화 클래스입니다.
 * => web.xml 없이 SpringMVC 실행
 *
 * 루트 컨테이너, DispatcherServlet, URL 매핑, 인코딩 필터를 직접 등록합니다.
 *
 * AbstractAnnotationConfigDispatcherServletInitializer : Spring이 제공하는 초기화 템플릿 클래스
 */
public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        // 서비스, 저장소, 보안 설정이 들어가는 부모 ApplicationContext입니다.
        return new Class<?>[] { RootConfig.class, SecurityConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        // Controller, ViewResolver 등 웹 계층 전용 설정입니다.
        return new Class<?>[] { WebMvcConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
        // 모든 요청을 Spring MVC의 DispatcherServlet으로 전달합니다.
        return new String[] { "/" };
    }

    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        return new Filter[] { filter };
    }
}

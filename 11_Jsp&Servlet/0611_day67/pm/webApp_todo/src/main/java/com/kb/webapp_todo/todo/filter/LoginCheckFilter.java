package com.kb.webapp_todo.todo.filter;

import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/todo/*"})
@Log4j2
public class LoginCheckFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("Login doFilter........");

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        HttpSession session = request.getSession();

        if(session.getAttribute("loginInfo") == null) {
            response.sendRedirect("/login");
            return;
        }

        filterChain.doFilter(request, response);
    }
}

//Filter 인터페이스 import 할때 , javax.servlet의 Filter 인터페이스 사용
//Filter 인터페이스는 doFilter() 추상 메소드 => 필터가 필터링이 필요한 로직구현하는 부분이다.
//@WebFilter 특정한 경로를 지정해서 해당 경로로 요청(request)에 대해서 doFilter()
//를 실행하는 구조임. LoginCheckFilter 는 /todo/*  브라우저에서 /todo/...모든 경로에 대해 필터링을 한다.
//doFilter(filterChain) 경로를 이용해서 다음 목적지로 이동하여 필터링을 시도할 수 있다.












package com.kb.gallery.common.util;

import jakarta.servlet.http.HttpServletRequest;

public class HttpUtils {
    // 세션 입력
    // -- 로그인 성공한 사용자의 정보 저장할 때
    public static void setSession(HttpServletRequest request, String key, Object value) {
        request.getSession().setAttribute(key, value);
    }

    // 세션 값 조회
    // -- 로그인한 사용자의 회원 아이디 조회할 때
    public static Object getSession(HttpServletRequest request, String key) {
        return request.getSession().getAttribute(key);
    }

    // 세션 삭제
    // -- 사용자가 로그아웃 요청할 때
    public static void removeSession(HttpServletRequest request, String key) {
        request.getSession().removeAttribute(key);
    }
}

package com.kdt.security1.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 인증이 끝난 뒤 현재 사용자의 이름과 권한을 화면 모델에 전달합니다.
 * Authentication은 SecurityContext에 저장된 현재 인증 객체입니다.
 */
@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Authentication authentication, Model model) {
        model.addAttribute("username", authentication.getName());
        model.addAttribute("authorities", authentication.getAuthorities());
        return "home";
    }
}

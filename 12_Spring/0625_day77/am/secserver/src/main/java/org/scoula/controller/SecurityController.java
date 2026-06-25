package org.scoula.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@RequestMapping("/security")
@Controller
public class SecurityController {

    @GetMapping("/all")
    public void doAll() {
        log.info("모두 접근 가능");
    }

    @GetMapping("/member")
    public void doMember() {
        log.info("로그인한 사용자만 접근 가능");
    }

    @GetMapping("/admin")
    public void doAdmin() {
        log.info("관리자만 접근 가능");
    }

    @GetMapping("/login")
    public void login() {
        log.info("login page");
    }

    @GetMapping("/logout")
    public void logout() {
        log.info("logout page");
    }
}

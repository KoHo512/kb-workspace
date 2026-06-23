package org.scoula.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * 루트 페이지 확인용 Controller입니다.
 */
@Controller
@Slf4j
public class HomeController {

    @GetMapping("/")
    public String home() {
        log.info("HomeController / 요청");
        return "index";
    }
}

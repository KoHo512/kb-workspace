package com.kb.springex.controller;

import com.kb.springex.dto.TodoDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;

// SpringMVC에서 컨트롤러 역할을 하는 빈(Bean)
@Controller
@Log4j2
public class SampleController {

    @GetMapping("/hello")
    public void hello() {
        log.info("hello.........");
    }

    @GetMapping("/ex1")
    public void ex1(String name, int age) {
        log.info("GET /ex1 실행......");
        log.info("name : " + name);
        log.info("age : " + age);
    }

    @GetMapping("/ex2")
    public void ex12(
            @RequestParam(name = "name", defaultValue = "Hong") String name,
            @RequestParam(name = "age", defaultValue = "10") int age) {
        log.info("GET /ex2 실행......");
        log.info("name : " + name);
        log.info("age : " + age);
    }

    @GetMapping("/ex3")
    public void ex13(LocalDate dueDate) {
        log.info("GET /ex3 실행......");
        log.info("dueDate : " + dueDate);
    }

    @GetMapping("/ex4")
    public void ex14(Model model) {
        log.info("GET /ex4 실행......");
        model.addAttribute("message", "Hello Spring!");
    }

    @GetMapping("/ex4_1")
    public void ex15(Model model) {
        log.info("GET /ex4_1 실행......");

        // builder를 이용해 todoDTO 객체 구성하고 todoDTO를 ex4_1.jps 페이지에서 확인
        TodoDTO todoDTO = TodoDTO.builder()
                .tno(1L)
                .title("Spring MVC 학습")
                .dueDate(LocalDate.now())
                .finished(false)
                .writer("tester")
                .build();

        log.info(todoDTO);

        model.addAttribute("todo", todoDTO);
    }

    @GetMapping("/ex5")
    public String ex15(RedirectAttributes redirectAttributes) {
        log.info("GET /ex5 실행......");

        redirectAttributes.addAttribute("name", "Hong");
        redirectAttributes.addFlashAttribute("result", "success");

        return "redirect:/ex6";
    }

    @GetMapping("/ex6")
    public void ex16() {}

    @GetMapping("/ex7")
    public void ex17(String p1, int p2) {
        log.info("p1..." + p1);
        log.info("p2..." + p2);
    }

}

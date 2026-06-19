package com.kb.springex.controller;

import com.kb.springex.dto.TodoDTO;
import com.kb.springex.service.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDate;

@Controller
@RequestMapping("/todo")
@Log4j2
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @RequestMapping("/list")
    public void list(Model model) {
        log.info("GET /todo/list 호출......");
    }

    //    @RequestMapping(value = "/register", method = RequestMethod.GET)
    @GetMapping("/register")
    public void registerGet() {
        log.info("GET /todo/register 호출......");
    }

    @PostMapping("/register")
    public String registerPost(@Valid TodoDTO todoDTO,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {
        log.info("POST /todo/register 호출......");

        if (bindingResult.hasErrors()) {
            log.info("문제 발생......");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/todo/register";
        }

        log.info(todoDTO);

        todoService.register(todoDTO);

        return "redirect:/todo/list";
    }
}

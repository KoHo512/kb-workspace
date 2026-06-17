package com.kb.springex.controller;

import com.kb.springex.dto.TodoDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/todo")
@Log4j2
public class TodoController {

    @RequestMapping("/list")
    public void list() {
        log.info("GET /todo/list 호출......");
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public void register() {
        log.info("GET /todo/register 호출......");
    }

    @PostMapping("/register")
    public void register(TodoDTO todoDTO) {
        log.info("POST /todo/register 호출......");
        log.info(todoDTO);
    }
}

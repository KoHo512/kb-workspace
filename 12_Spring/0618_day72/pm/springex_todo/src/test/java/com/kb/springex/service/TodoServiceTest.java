package com.kb.springex.service;

import com.kb.springex.dto.TodoDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
class TodoServiceTest {

    @Autowired
    private TodoService service;
    @Autowired
    private TodoService todoService;

    @Test
    void register() {
        TodoDTO todoDTO = TodoDTO.builder()
                .title("new todo")
                .dueDate(LocalDate.now())
                .writer("user02")
                .build();

        todoService.register(todoDTO);
    }
}
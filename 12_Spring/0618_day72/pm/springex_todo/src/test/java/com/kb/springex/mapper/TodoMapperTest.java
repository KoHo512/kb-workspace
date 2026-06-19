package com.kb.springex.mapper;

import com.kb.springex.domain.TodoVO;
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
class TodoMapperTest {
    @Autowired(required = false)
    private TodoMapper todoMapper;

    @Test
    public void insert() {
        TodoVO todoVO = TodoVO.builder()
                .title("new todo")
                .dueDate(LocalDate.now())
                .writer("user00")
                .build();

        todoMapper.insert(todoVO);
    }
}
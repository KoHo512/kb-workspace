package com.kb.webapp_todo.todo.service;

import com.kb.webapp_todo.todo.dto.TodoDTO;

import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// TodoService 서비스 객체
// enum 타입으로 클래스 작성 장점 : 정해진 수만큼 객체 생성 가능
// TodoService.INSTANCE (싱글톤 패턴)
// 항상 하나의 객체만을 가르키게 됨 = 객체를 하나만 생성해서 사용
// 여러 컨트롤러들이 TodoService 객체를 통해 원하는 데이터를 주고 받는 구조
public enum TodoService {
    INSTANCE;

    public void register(TodoDTO todoDTO) {
        System.out.println("DEBUG ......" + todoDTO);
    }

    public List<TodoDTO> getList() {
        List<TodoDTO> todoDTOList = IntStream.range(1, 11).mapToObj(i -> {
            TodoDTO dto = new TodoDTO();
            dto.setTno((long) i);
            dto.setTitle("Todo_" + i);
            dto.setDueDate(LocalDateTime.now());

            return dto;
        }).collect(Collectors.toList());

        return todoDTOList;
    }
}

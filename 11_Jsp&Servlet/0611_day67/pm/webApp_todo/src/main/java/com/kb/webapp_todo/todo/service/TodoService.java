package com.kb.webapp_todo.todo.service;

import com.kb.webapp_todo.todo.dao.TodoDAO;
import com.kb.webapp_todo.todo.domain.TodoVO;
import com.kb.webapp_todo.todo.dto.TodoDTO;
import com.kb.webapp_todo.todo.util.MapperUtil;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// TodoService 서비스 객체
// enum 타입으로 클래스 작성 장점 : 정해진 수만큼 객체 생성 가능
// TodoService.INSTANCE (싱글톤 패턴)
// 항상 하나의 객체만을 가르키게 됨 = 객체를 하나만 생성해서 사용
// 여러 컨트롤러들이 TodoService 객체를 통해 원하는 데이터를 주고 받는 구조
@Log4j2
public enum TodoService {
    INSTANCE;

    private TodoDAO dao;
    private ModelMapper modelMapper;

    TodoService() {
        this.dao = new TodoDAO();
        this.modelMapper = MapperUtil.INSTANCE.get();
    }

    public void register(TodoDTO todoDTO) throws Exception {
//        System.out.println("DEBUG ......" + todoDTO);
        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);
        log.info(todoVO);
        dao.insert(todoVO);
    }

    public List<TodoDTO> getList() {
        List<TodoDTO> todoDTOList = IntStream.range(1, 11).mapToObj(i -> {
            TodoDTO dto = new TodoDTO();
            dto.setTno((long) i);
            dto.setTitle("Todo_" + i);
            dto.setDueDate(LocalDate.now());

            return dto;
        }).collect(Collectors.toList());

        return todoDTOList;
    }

    // Todo 하나를 선택해서 읽는 기능
    public TodoDTO get(Long tno) {
        TodoDTO dto = new TodoDTO();

        dto.setTno(tno);
        dto.setTitle("Sample Data");
        dto.setDueDate(LocalDate.now());
        dto.setFinished(true);

        return dto;
    }

    public List<TodoDTO> listAll() throws Exception {
        List<TodoVO> voList = dao.selectAll();
        log.info("voList-------------");
        log.info(voList);

        List<TodoDTO> dtoList = voList.stream().map(
                vo -> modelMapper.map(vo, TodoDTO.class)).collect(Collectors.toList());

        return dtoList;
    }

    public void remove(Long tno) throws Exception {
        log.info("tno: " + tno);
        dao.deleteOne(tno);
    }

    public void modify(TodoDTO todoDTO) throws Exception {
        log.info("todoDTO: " + todoDTO);

        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);
        dao.updateOne(todoVO);
    }
}

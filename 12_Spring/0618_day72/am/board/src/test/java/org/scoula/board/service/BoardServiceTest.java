package org.scoula.board.service;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.scoula.board.dto.BoardDTO;
import org.scoula.config.RootConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {RootConfig.class})
@Log4j2
class BoardServiceTest {
    @Autowired
    private BoardService service;

    @Test
    void getList() {
        for (BoardDTO board : service.getList()) {
            log.info(board);
        }
    }

    @Test
    void get() {
        log.info(service.get(1L));
    }

    @Test
    void create() {
        BoardDTO board = new BoardDTO();

        board.setTitle("새 글 제목");
        board.setContent("새 글 내용");
        board.setWriter("user01");

        service.create(board);

        log.info("생성된 게시글 no : " + board.getNo());
    }

    @Test
    void update() {
        BoardDTO board = service.get(1L);

        board.setTitle("제목 수정");

        log.info("수정 결과 : " + service.update(board));
    }

    @Test
    void delete() {
        log.info("삭제 결과 : " + service.delete(2L));
    }
}
package org.scoula.board.mapper;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.scoula.board.domain.BoardVO;
import org.scoula.config.RootConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {RootConfig.class})
@Log4j2
class BoardMapperTest {

    @Autowired
    private BoardMapper mapper;

    @Test
    @DisplayName("BoardMapper 목록")
    public void getList() {
        for (BoardVO board : mapper.getList()) {
            log.info(board);
        }
    }

    @Test
    @DisplayName("BoardMapper 게시글")
    public void get() {
        BoardVO board = mapper.get(1L);
        log.info(board);
    }

    @Test
    @DisplayName("BoardMapper 새 글 작성")
    public void create() {
        BoardVO board = new BoardVO();

        board.setTitle("새 글");
        board.setContent("새 글 내용");
        board.setWriter("user00");

        mapper.create(board);

        log.info(board);
    }

    @Test
    @DisplayName("BoardMapper 글 수정")
    public void update() {
        BoardVO board = new BoardVO();

        board.setNo(6L);
        board.setTitle("수정한 제목");
        board.setContent("수정한 내용");
        board.setWriter("user00");

        int count = mapper.update(board);

        log.info("UPDATE COUNT : " + count);
    }

    @Test
    @DisplayName("BoardMapper 글 삭제")
    public void delete() {
        int count = mapper.delete(3L);

        log.info("DELETE COUNT : " + count);
    }
}
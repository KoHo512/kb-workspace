package org.scoula.board.mapper;

import org.scoula.board.domain.BoardVO;

import java.util.List;

/**
 *
 * Mapper Interface입니다. XML의 id와 메서드명이 일치해야 합니다.
 */
public interface BoardMapper {
    List<BoardVO> getList();
    BoardVO get(Long no);
    int create(BoardVO board);
    int update(BoardVO board);
    int delete(Long no);
}

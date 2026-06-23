package org.scoula.board.service;

import org.scoula.board.dto.BoardDTO;

import java.util.List;

/**
 *
 * REST API는 CUD 처리 후 처리된 객체를 반환하도록 설계합니다.
 */
public interface BoardService {
    List<BoardDTO> getList();
    BoardDTO get(Long no);
    BoardDTO create(BoardDTO board);
    BoardDTO update(BoardDTO board);
    BoardDTO delete(Long no);
}

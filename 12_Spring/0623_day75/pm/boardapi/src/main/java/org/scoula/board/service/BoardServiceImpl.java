package org.scoula.board.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.scoula.board.domain.BoardVO;
import org.scoula.board.dto.BoardDTO;
import org.scoula.board.mapper.BoardMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * Service 구현 클래스입니다.
 */
@Service
@RequiredArgsConstructor
@Log4j2
public class BoardServiceImpl implements BoardService {

    private final BoardMapper mapper;

    @Override
    public List<BoardDTO> getList() {
        // TODO 1
        // mapper.getList() 결과를 BoardDTO 리스트로 변환하세요.
        return mapper.getList()
                .stream()
                .map(BoardDTO::of)
                .collect(Collectors.toList());
    }

    @Override
    public BoardDTO get(Long no) {
        // TODO 2
        // mapper.get(no) 결과를 BoardDTO로 변환하세요.
        return BoardDTO.of(mapper.get(no));
    }

    @Transactional
    @Override
    public BoardDTO create(BoardDTO board) {
        // TODO 3
        // 1. DTO를 VO로 변환
        // 2. mapper.create() 호출
        // 3. useGeneratedKeys로 생성된 no를 이용해 get(no) 반환
        BoardVO boardVO = board.toVo();
        mapper.create(boardVO);
        return get(boardVO.getNo());
    }

    @Transactional
    @Override
    public BoardDTO update(BoardDTO board) {
        // TODO 4
        // 1. DTO를 VO로 변환해 수정
        // 2. 수정된 객체를 다시 조회해서 반환
        mapper.update(board.toVo());
        return get(board.getNo());
    }

    @Transactional
    @Override
    public BoardDTO delete(Long no) {
        // TODO 5
        // 1. 삭제 전 객체 조회
        // 2. mapper.delete(no) 호출
        // 3. 삭제 전 객체 반환
        BoardDTO deleted = get(no);
        mapper.delete(no);
        return deleted;
    }
}

package com.example.jdbc.service;

import com.example.jdbc.common.TransactionManager;
import com.example.jdbc.dao.BoardDao;
import com.example.jdbc.domain.Board;

import java.util.List;
import java.util.Optional;

/**
 * BoardService
 * ------------------------------------------------------------
 * 게시판 관련 비즈니스 로직을 담당합니다.
 */
public class BoardService {

    private final BoardDao boardDao;

    public BoardService(BoardDao boardDao) {
        this.boardDao = boardDao;
    }

    public Integer save(Board board) throws Exception {
        validate(board);

        return TransactionManager.execute(
                con -> boardDao.insert(con, board)
        );
    }

    public Optional<Board> findById(Integer bno) throws Exception {
        return TransactionManager.execute(
                con -> boardDao.findById(con, bno)
        );
    }

    public List<Board> findAll() throws Exception {
        return TransactionManager.execute(boardDao::findAll);
    }

    public int update(Board board) throws Exception {
        if (board.getBno() == null) {
            throw new IllegalArgumentException("수정하려면 Board.bno가 필요합니다.");
        }

        validate(board);

        return TransactionManager.execute(
                con -> boardDao.update(con, board)
        );
    }

    public int delete(Integer bno) throws Exception {
        return TransactionManager.execute(
                con -> boardDao.delete(con, bno)
        );
    }

    public byte[] downloadFile(Integer bno) throws Exception {
        return TransactionManager.execute(
                con -> boardDao.downloadFile(con, bno)
        );
    }

    private void validate(Board board) {
        if (board == null) {
            throw new IllegalArgumentException("Board 객체가 null입니다.");
        }

        if (board.getTitle() == null || board.getTitle().isBlank()) {
            throw new IllegalArgumentException("게시글 제목은 필수입니다.");
        }

        if (board.getWriter() == null || board.getWriter().isBlank()) {
            throw new IllegalArgumentException("작성자는 필수입니다.");
        }
    }
}

package com.example.jdbc.dao;

import com.example.jdbc.domain.Board;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * BoardDao
 * ------------------------------------------------------------
 * boards 테이블 CRUD와 BLOB 파일 처리를 담당합니다.
 *
 * 실무 포인트:
 * - 목록 조회(findAll)에서는 BLOB 데이터를 가져오지 않습니다.
 *   파일 데이터는 크기 때문에 목록에서 매번 가져오면 성능이 나빠집니다.
 * - 상세 조회나 다운로드 시점에만 bfiledata를 조회합니다.
 */
public class BoardDao implements GenericDao<Board, Integer> {

    @Override
    public Integer insert(Connection con, Board board) throws Exception {
        String sql = """
                INSERT INTO boards
                (
                    btitle,
                    bcontent,
                    bwriter,
                    bfilename,
                    bfiledata
                )
                VALUES
                (
                    ?, ?, ?, ?, ?
                )
                """;

        try (PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, board.getTitle());
            pstmt.setString(2, board.getContent());
            pstmt.setString(3, board.getWriter());
            pstmt.setString(4, board.getFileName());
            pstmt.setBytes(5, board.getFileData());

            pstmt.executeUpdate();

            try (ResultSet rs = pstmt.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }

            throw new SQLException("boards insert 후 생성된 bno를 가져오지 못했습니다.");
        }
    }

    @Override
    public Optional<Board> findById(Connection con, Integer bno) throws Exception {
        String sql = """
                SELECT bno, btitle, bcontent, bwriter, bdate, bfilename, bfiledata
                FROM boards
                WHERE bno = ?
                """;

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, bno);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(mapToBoardWithFile(rs));
                }
            }
        }

        return Optional.empty();
    }

    @Override
    public List<Board> findAll(Connection con) throws Exception {
        String sql = """
                SELECT bno, btitle, bcontent, bwriter, bdate, bfilename
                FROM boards
                ORDER BY bno DESC
                """;
        List<Board> boards = new ArrayList<>();

        try (
                PreparedStatement pstmt = con.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery()
        ) {
            while (rs.next()) {
                boards.add(mapToBoardWithoutFile(rs));
            }
        }

        return boards;
    }

    @Override
    public int update(Connection con, Board board) throws Exception {
        String sql = """
                UPDATE boards
                SET btitle = ?, bcontent = ?, bwriter = ?, bfilename = ?, bfiledata = ?
                WHERE bno = ?
                """;

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, board.getTitle());
            pstmt.setString(2, board.getContent());
            pstmt.setString(3, board.getWriter());
            pstmt.setString(4, board.getFileName());
            pstmt.setBytes(5, board.getFileData());
            pstmt.setInt(6, board.getBno());

            return pstmt.executeUpdate();
        }
    }

    @Override
    public int delete(Connection con, Integer bno) throws Exception {
        String sql = "DELETE FROM boards WHERE bno = ?";

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, bno);
            return pstmt.executeUpdate();
        }
    }

    public byte[] downloadFile(Connection con, Integer bno) throws Exception {
        String sql = "SELECT bfiledata FROM boards WHERE bno = ?";

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, bno);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getBytes("bfiledata");
                }
            }
        }

        return null;
    }

    private Board mapToBoardWithFile(ResultSet rs) throws SQLException {
        Timestamp timestamp = rs.getTimestamp("bdate");

        return Board.builder()
                .bno(rs.getInt("bno"))
                .title(rs.getString("btitle"))
                .content(rs.getString("bcontent"))
                .writer(rs.getString("bwriter"))
                .createdAt(timestamp == null ? null : timestamp.toLocalDateTime())
                .fileName(rs.getString("bfilename"))
                .fileData(rs.getBytes("bfiledata"))
                .build();
    }

    private Board mapToBoardWithoutFile(ResultSet rs) throws SQLException {
        Timestamp timestamp = rs.getTimestamp("bdate");

        return Board.builder()
                .bno(rs.getInt("bno"))
                .title(rs.getString("btitle"))
                .content(rs.getString("bcontent"))
                .writer(rs.getString("bwriter"))
                .createdAt(timestamp == null ? null : timestamp.toLocalDateTime())
                .fileName(rs.getString("bfilename"))
                .build();
    }
}

package com.example.jdbc.dao;

import com.example.jdbc.domain.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * UserDao
 * ------------------------------------------------------------
 * users 테이블의 CRUD SQL을 담당합니다.
 *
 * 변경 핵심:
 * - PK는 id(Integer)입니다.
 * - userid는 로그인 ID이며 UNIQUE로 관리합니다.
 */
public class UserDao implements GenericDao<User, Integer> {

    @Override
    public Integer insert(Connection con, User user) throws Exception {
        String sql = """
                INSERT INTO users
                (
                    userid,
                    username,
                    userpassword,
                    userage,
                    useremail
                )
                VALUES
                (
                    ?, ?, ?, ?, ?
                )
                """;

        try (PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, user.getUserId());
            pstmt.setString(2, user.getUsername());
            pstmt.setString(3, user.getUserPassword());

            if (user.getUserAge() == null) {
                pstmt.setNull(4, Types.INTEGER);
            } else {
                pstmt.setInt(4, user.getUserAge());
            }

            pstmt.setString(5, user.getUserEmail());
            pstmt.executeUpdate();

            try (ResultSet rs = pstmt.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }

            throw new SQLException("users insert 후 생성된 id를 가져오지 못했습니다.");
        }
    }

    @Override
    public Optional<User> findById(Connection con, Integer id) throws Exception {
        String sql = """
                SELECT id, userid, username, userpassword, userage, useremail
                FROM users
                WHERE id = ?
                """;

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, id);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(mapToUser(rs));
                }
            }
        }

        return Optional.empty();
    }

    public Optional<User> findByUserId(Connection con, String userId) throws Exception {
        String sql = """
                SELECT id, userid, username, userpassword, userage, useremail
                FROM users
                WHERE userid = ?
                """;

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, userId);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(mapToUser(rs));
                }
            }
        }

        return Optional.empty();
    }

    @Override
    public List<User> findAll(Connection con) throws Exception {
        String sql = """
                SELECT id, userid, username, userpassword, userage, useremail
                FROM users
                ORDER BY id DESC
                """;
        List<User> users = new ArrayList<>();

        try (
                PreparedStatement pstmt = con.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery()
        ) {
            while (rs.next()) {
                users.add(mapToUser(rs));
            }
        }

        return users;
    }

    @Override
    public int update(Connection con, User user) throws Exception {
        String sql = """
                UPDATE users
                SET userid = ?, username = ?, userpassword = ?, userage = ?, useremail = ?
                WHERE id = ?
                """;

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, user.getUserId());
            pstmt.setString(2, user.getUsername());
            pstmt.setString(3, user.getUserPassword());

            if (user.getUserAge() == null) {
                pstmt.setNull(4, Types.INTEGER);
            } else {
                pstmt.setInt(4, user.getUserAge());
            }

            pstmt.setString(5, user.getUserEmail());
            pstmt.setInt(6, user.getId());

            return pstmt.executeUpdate();
        }
    }

    @Override
    public int delete(Connection con, Integer id) throws Exception {
        String sql = "DELETE FROM users WHERE id = ?";

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            return pstmt.executeUpdate();
        }
    }

    private User mapToUser(ResultSet rs) throws SQLException {
        int age = rs.getInt("userage");
        Integer nullableAge = rs.wasNull() ? null : age;

        return User.builder()
                .id(rs.getInt("id"))
                .userId(rs.getString("userid"))
                .username(rs.getString("username"))
                .userPassword(rs.getString("userpassword"))
                .userAge(nullableAge)
                .userEmail(rs.getString("useremail"))
                .build();
    }
}

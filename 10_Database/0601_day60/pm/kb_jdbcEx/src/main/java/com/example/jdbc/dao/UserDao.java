package com.example.jdbc.dao;

import com.example.jdbc.common.DBUtil;
import com.example.jdbc.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDao {
    private final DBUtil dbUtil;

    public UserDao(DBUtil dbUtil) {
        this.dbUtil = dbUtil;
    }

    public int insert(User user) throws SQLException {
        String sql = "INSERT INTO users(userid, username, userpassword, userage, useremail) VALUES(?, ?, ?, ?, ?)";
        try (Connection con = dbUtil.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, user.getUserId());
            pstmt.setString(2, user.getUsername());
            pstmt.setString(3, user.getUserPassword());
            pstmt.setInt(4, user.getUserAge());
            pstmt.setString(5, user.getUserEmail());
            return pstmt.executeUpdate();
        }
    }
}

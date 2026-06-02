package com.example.person.common;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
    static {
        try {
            Class.forName(DBConfig.get("db.driver"));
        } catch (Exception e) {
            throw new RuntimeException("JDBC 드라이버 로드에 실패했습니다.", e);
        }
    }

    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(
                DBConfig.get("db.url"),
                DBConfig.get("db.username"),
                DBConfig.get("db.password")
        );
    }
}

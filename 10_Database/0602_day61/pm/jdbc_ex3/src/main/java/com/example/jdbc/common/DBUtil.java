package com.example.jdbc.common;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * DBUtil
 * ------------------------------------------------------------
 * 역할:
 * - JDBC Driver를 로딩합니다.
 * - DB Connection 객체를 생성합니다.
 *
 * 주의:
 * - DAO에서 직접 DBUtil.getConnection()을 호출하지 않습니다.
 * - Service -> TransactionManager -> DAO 순서로 Connection을 전달
 */
public class DBUtil {

    static {
        try {
            Class.forName(DBConfig.get("db.driver"));
        } catch (Exception e) {
            throw new RuntimeException("JDBC 드라이버 로딩 실패", e);
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

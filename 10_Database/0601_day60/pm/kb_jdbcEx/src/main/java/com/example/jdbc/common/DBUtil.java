package com.example.jdbc.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * JDBC Connection 생성 책임을 담당하는 유틸 클래스입니다.
 * 기존 예제의 DriverManager.getConnection(...) 중복 코드를 한 곳으로 모았습니다.
 */
public class DBUtil {
    private final DBConfig config;

    public DBUtil(DBConfig config) {
        this.config = config;
        loadDriver(config.driver());
    }

    public static DBUtil defaultConfig() {
        return new DBUtil(DBConfig.fromClasspath("db.properties"));
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(config.url(), config.username(), config.password());
    }

    private void loadDriver(String driverName) {
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("JDBC 드라이버 로딩 실패: " + driverName, e);
        }
    }
}

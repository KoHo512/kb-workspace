package org.scoula.persistence;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * JDBC 드라이버를 직접 사용하여 MySQL 연결을 검증하는 테스트입니다.
 *
 * <p>이 테스트는 Spring Container를 사용하지 않습니다.
 * PDF 3페이지의 "JDBC 드라이버를 통해 DB 연결 테스트 코드를 작성" 요구사항을 반영합니다.</p>
 */
class JDBCTests {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/scoula_db?serverTimezone=Asia/Seoul&characterEncoding=UTF-8&useSSL=false&allowPublicKeyRetrieval=true";
    private static final String USER = "scoula";
    private static final String PASSWORD = "1234";

    @Test
    @DisplayName("JDBC DriverManager로 MySQL DB 연결 테스트")
    void testConnection() throws Exception {
        Class.forName(DRIVER);

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("connection = " + connection);
            assertNotNull(connection);
        }
    }
}

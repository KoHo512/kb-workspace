package jdbc.exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    // 1. JDBC 드라이버 로딩
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    // 2. MySQL 서버가 제공하는 Connection 객체(=세션)를 얻기 위해 필요한 인증 정보
    private static final String URL = "jdbc:mysql://localhost:3306/kbbookstore?serverTimezone=Asia/Seoul&characterEncoding=UTF-8";
    private static final String USER = "kbbookadmin";
    private static final String PASSWORD = "1234";

    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            throw new ExceptionInInitializerError("MySQL 드라이버 로딩 실패");
        }
    }

    // 객체 생성을 막기 위해 DBUtil 생성자를 private 생성자로 사용
    private DBUtil() {

    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void close(AutoCloseable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}

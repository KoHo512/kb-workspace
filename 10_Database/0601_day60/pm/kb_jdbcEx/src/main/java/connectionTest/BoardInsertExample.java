//package connectionTest;
//
//import java.sql.*;
//
///**
// * Java Database Connect 5단계
// * 1. JDBC 드라이버 로딩
// * 2. Connection 객체 생성
// * 3. 쿼리 작성 -> Statement 객체, PrepareStatement 객체
// * 4. 결과 처리 (DML 중 INSERT Delete, Update 결과 정수값, Select ResultSet 객체)
// * 5. Connection close()
// */
//public class BoardInsertExample {
//    public static void main(String[] args) {
//        Connection conn = null;
//
//        try {
//            // 1. 드라이버 로딩
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            System.out.println("Driver 로딩 완");
//
//            // 2. Connection 객체 생성
//            conn = DriverManager.getConnection("jdbc:mysql://10.10.0.160:3306/jdbc_ex1?serverTimezone=Asia/Seoul&characterEncoding=UTF-8", "scoula", "1234");
//            System.out.println("Connection 생성 완 : " + conn.toString());
//
//            // 3. 매개변수화된 SQL문 작성
//            String sql = "INSERT INTO board (btitle, bcontent, bwriter, bdate, bfilename, bfiledata) VALUES (?, ?, ?, NOW(), ?, ?)";
//
//            // 4. PreparedStatement를 얻어 값 지정
//            try (PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
//                pstmt.setString(1, "제목1");
//                pstmt.setString(2, "내용1");
//                pstmt.setString(3, "작성자1");
//                pstmt.setString(4, "file.jpg");
//                pstmt.setString(5, "");
//
//                // 5. SQL문 실행
//                int result = pstmt.executeUpdate();
//                if (result != 1) return;
//
//            }
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            if (conn != null) {
//                try {
//                    conn.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//}

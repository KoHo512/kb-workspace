package jdbc.exam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 * BookDAO 클래스는 bookstore 테이블에 접근하는 데이터 접근 객체입니다.
 *
 * DAO(Data Access Object)는 SQL 실행 로직을 담당합니다.
 * 화면 입력과 출력은 BookStore가 담당하고, DB 처리는 BookDAO가 담당하게 하여
 * 역할을 분리했습니다.
 */
public class BookDAO {

    /**
     * 도서 정보를 bookstore 테이블에 등록합니다.
     *
     * @param isbn 도서 ISBN 번호
     * @param title 도서명
     * @param writer 저자명
     * @param price 가격
     * @return insert된 행의 개수
     */
    public int insert(int isbn, String title, String writer, int price) {
        String sql = "INSERT INTO bookstore (isbn, title, writer, price) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, isbn);
            pstmt.setString(2, title);
            pstmt.setString(3, writer);
            pstmt.setInt(4, price);

            return pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("도서 등록 중 DB 오류 발생: " + e.getMessage());
            return 0;
        }
    }

    /**
     * isbn이 일치하는 도서의 가격을 수정합니다.
     *
     * @param isbn 수정할 도서 ISBN 번호
     * @param price 새 가격
     * @return update된 행의 개수
     */
    public int update(int isbn, int price) {
        String sql = "UPDATE bookstore SET price = ? WHERE isbn = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, price);
            pstmt.setInt(2, isbn);

            return pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("도서 수정 중 DB 오류 발생: " + e.getMessage());
            return 0;
        }
    }

    /**
     * isbn이 일치하는 도서를 삭제합니다.
     *
     * @param isbn 삭제할 도서 ISBN 번호
     * @return delete된 행의 개수
     */
    public int delete(int isbn) {
        String sql = "DELETE FROM bookstore WHERE isbn = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, isbn);

            return pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("도서 삭제 중 DB 오류 발생: " + e.getMessage());
            return 0;
        }
    }

    /**
     * isbn이 일치하는 도서 정보를 조회합니다.
     * 문제 문서의 요구사항에 맞춰 Vector 형태로 반환합니다.
     *
     * @param isbn 검색할 도서 ISBN 번호
     * @return 검색 결과 Vector
     */
    public Vector<Book> search(int isbn) {
        Vector<Book> books = new Vector<>();
        String sql = "SELECT isbn, title, writer, price FROM bookstore WHERE isbn = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, isbn);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    books.add(new Book(
                            rs.getInt("isbn"),
                            rs.getString("title"),
                            rs.getString("writer"),
                            rs.getInt("price")
                    ));
                }
            }
        } catch (SQLException e) {
            System.out.println("도서 검색 중 DB 오류 발생: " + e.getMessage());
        }

        return books;
    }

    /**
     * bookstore 테이블의 전체 도서 정보를 조회합니다.
     *
     * @return 전체 도서 목록 Vector
     */
    public Vector<Book> list() {
        Vector<Book> books = new Vector<>();
        String sql = "SELECT isbn, title, writer, price FROM bookstore ORDER BY isbn";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                books.add(new Book(
                        rs.getInt("isbn"),
                        rs.getString("title"),
                        rs.getString("writer"),
                        rs.getInt("price")
                ));
            }
        } catch (SQLException e) {
            System.out.println("도서 목록 조회 중 DB 오류 발생: " + e.getMessage());
        }

        return books;
    }
}
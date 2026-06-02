package jdbc.exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

/**
 * BookStore 클래스는 콘솔 화면 메뉴와 사용자 입력을 담당하는 실행 클래스입니다.
 *
 * 문서 요구사항
 * - 패키지명: jdbc.exam
 * - 입력 방식: BufferedReader 사용
 * - 0번 메뉴를 입력했을 때만 프로그램 종료
 * - 도서등록, 도서수정, 도서삭제, 도서검색, 도서리스트 기능 구현
 */
public class BookStore {

    /** 키보드 입력을 받기 위한 BufferedReader입니다. */
    private final BufferedReader br;

    /** DB 작업을 수행하는 DAO 객체입니다. */
    private final BookDAO dao;

    /** 프로그램 반복 실행 여부입니다. 0번 종료 메뉴에서만 false로 변경합니다. */
    private boolean running;

    /**
     * BookStore 객체 생성 시 BufferedReader와 BookDAO를 초기화합니다.
     */
    public BookStore() {
        this.br = new BufferedReader(new InputStreamReader(System.in));
        this.dao = new BookDAO();
        this.running = true;
    }

    /**
     * 프로그램 시작 메소드입니다.
     * BookStore 객체를 생성한 뒤 menu()를 호출합니다.
     */
    public static void main(String[] args) {
        BookStore bookStore = new BookStore();
        bookStore.menu();
    }

    /**
     * 메뉴를 출력하고 사용자가 선택한 번호에 따라 기능 메소드를 호출합니다.
     * 프로그램은 반드시 0번 메뉴를 선택했을 때만 종료됩니다.
     */
    public void menu() {
        while (running) {
            printMenu();

            try {
                int choice = readInt("번호를 선택하세요 : ");

                switch (choice) {
                    case 1:
                        register();
                        break;
                    case 2:
                        modify();
                        break;
                    case 3:
                        delete();
                        break;
                    case 4:
                        search();
                        break;
                    case 5:
                        list();
                        break;
                    case 0:
                        exit();
                        break;
                    default:
                        System.out.println("잘못된 번호입니다. 0~5 사이의 번호를 입력하세요.");
                }
            } catch (IOException e) {
                System.out.println("입력 처리 중 오류 발생: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("숫자만 입력하세요.");
            }
        }
    }

    /**
     * 문서의 화면구성1과 같은 메뉴 화면을 출력합니다.
     */
    private void printMenu() {
        System.out.println("============== 번호 선택 ==============");
        System.out.println("1. 도서등록");
        System.out.println("2. 도서수정");
        System.out.println("3. 도서삭제");
        System.out.println("4. 도서검색");
        System.out.println("5. 도서리스트");
        System.out.println("---------------------------------------");
        System.out.println("0. 프로그램 종료");
        System.out.println("=======================================");
    }

    /**
     * 도서 정보를 입력받아 DAO의 insert 메소드를 호출합니다.
     */
    public void register() throws IOException {
        System.out.println("----- 등록할 도서정보 입력 -----");

        int isbn = readInt("ISBN : ");
        String title = readString("도서명 : ");
        String writer = readString("저자 : ");
        int price = readInt("가격 : ");

        int result = dao.insert(isbn, title, writer, price);

        if (result > 0) {
            System.out.println("도서 등록 완료!!");
        } else {
            System.out.println("도서 등록 실패!!");
        }
    }

    /**
     * isbn과 가격을 입력받아 DAO의 update 메소드를 호출합니다.
     */
    public void modify() throws IOException {
        System.out.println("----- 수정할 도서정보 입력 -----");

        int isbn = readInt("ISBN : ");
        int price = readInt("가격 : ");

        int result = dao.update(isbn, price);

        if (result > 0) {
            System.out.println("도서 수정 완료!!");
        } else {
            System.out.println("수정할 도서가 없습니다.");
        }
    }

    /**
     * isbn을 입력받아 DAO의 delete 메소드를 호출합니다.
     */
    public void delete() throws IOException {
        System.out.println("----- 삭제할 도서정보 입력 -----");

        int isbn = readInt("ISBN : ");

        int result = dao.delete(isbn);

        if (result > 0) {
            System.out.println("도서 삭제 완료!!");
        } else {
            System.out.println("삭제할 도서가 없습니다.");
        }
    }

    /**
     * isbn을 입력받아 DAO의 search 메소드를 호출하고 결과를 출력합니다.
     */
    public void search() throws IOException {
        System.out.println("----- 검색할 도서정보 입력 -----");

        int isbn = readInt("ISBN : ");
        Vector<Book> books = dao.search(isbn);

        System.out.println("ISBN\t도서명\t저자\t가격");
        System.out.println("---------------------------------------");

        if (books.isEmpty()) {
            System.out.println("검색 결과가 없습니다.");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    /**
     * DAO의 list 메소드를 호출하여 모든 도서 정보를 출력합니다.
     */
    public void list() {
        System.out.println("----- 도서리스트 -----");

        Vector<Book> books = dao.list();

        System.out.println("ISBN\t도서명\t저자\t가격");
        System.out.println("---------------------------------------");

        if (books.isEmpty()) {
            System.out.println("등록된 도서가 없습니다.");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    /**
     * 프로그램을 종료합니다.
     * 이 메소드는 메뉴에서 0번을 선택했을 때만 호출됩니다.
     */
    public void exit() {
        System.out.println("프로그램을 종료합니다.");
        running = false;
    }

    /**
     * 문자열을 입력받는 공통 메소드입니다.
     *
     * @param message 입력 안내 메시지
     * @return 입력된 문자열
     */
    private String readString(String message) throws IOException {
        System.out.print(message);
        return br.readLine();
    }

    /**
     * 정수를 입력받는 공통 메소드입니다.
     * BufferedReader는 문자열로 입력을 받기 때문에 Integer.parseInt로 변환합니다.
     *
     * @param message 입력 안내 메시지
     * @return 입력된 정수
     */
    private int readInt(String message) throws IOException {
        System.out.print(message);
        return Integer.parseInt(br.readLine().trim());
    }
}
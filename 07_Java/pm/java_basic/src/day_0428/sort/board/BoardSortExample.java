package day_0428.sort.board;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BoardSortExample {
    public static void run() {
        List<Board> boards = new ArrayList<>();
        boards.add(new Board("Java 컬렉션 정리", 120, LocalDateTime.of(2026, 4, 20, 10, 0)));
        boards.add(new Board("Comparator 실습", 250, LocalDateTime.of(2026, 4, 21, 14, 30)));
        boards.add(new Board("Spring Boot 게시판", 250, LocalDateTime.of(2026, 4, 22, 9, 10)));
        boards.add(new Board("Iterator 사용법", 80, LocalDateTime.of(2026, 4, 19, 16, 0)));

        System.out.println("최신순");
        boards.sort(Comparator.comparing(Board::getCreatedAt).reversed());
        print(boards);

        System.out.println("\n조회수 높은 순");
        boards.sort(Comparator.comparingInt(Board::getViewCount).reversed());
        print(boards);

        System.out.println("\n조회수 높은 순, 조회수가 같으면 최신순");
        boards.sort(
                Comparator.comparingInt(Board::getViewCount).reversed()
                        .thenComparing(Comparator.comparing(Board::getCreatedAt).reversed())
        );
        print(boards);

        System.out.println("\n제목 가나다순");
        boards.sort(Comparator.comparing(Board::getTitle));
        print(boards);
    }

    private static void print(List<Board> boards) {
        for (Board board : boards) {
            System.out.println(board);
        }
    }
}

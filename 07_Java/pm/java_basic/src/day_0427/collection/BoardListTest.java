package day_0427.collection;

import java.util.ArrayList;
import java.util.List;

public class BoardListTest {
    public static void main(String[] args) {
        List<Board> list1 = new ArrayList<>();
        list1.add(new Board("제목1", "내용1", "jyw"));
        list1.add(new Board("제목2", "내용2", "jyw"));
        list1.add(new Board("제목3", "내용3", "jyw"));

        System.out.println("현재 게시판 글 수 : " + list1.size() + "개");

//        for (Board board : list1) {
//            System.out.print("제목 : " + board.getSubject());
//            System.out.print(" / 내용 : " + board.getContent());
//            System.out.println(" / 작성자 : " + board.getWriter());
//        }

//        for (int i = 0; i < list1.size(); i++) {
//            Board board = list1.get(i);
//            System.out.print("제목 : " + board.getSubject());
//            System.out.print(" / 내용 : " + board.getContent());
//            System.out.println(" / 작성자 : " + board.getWriter());
//        }

        printBoard(list1);

        list1.remove(2);
        System.out.println();

        System.out.println("현재 게시판 글 수 : " + list1.size() + "개");
        printBoard(list1);
    }

    public static void printBoard(List<Board> list) {
        for (Board board : list) {
            System.out.print("제목 : " + board.getSubject());
            System.out.print(" / 내용 : " + board.getContent());
            System.out.println(" / 작성자 : " + board.getWriter());
        }
    }
}

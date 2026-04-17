package day_0417;

import java.util.Scanner;

public class BookInfo {
    public static void main(String[] args) {
        String title, publisher, author, isbn;
        int price, pages;

        Scanner input = new Scanner(System.in);

        title = input.next();
        price = input.nextInt();
        publisher = input.next();
        author = input.next();
        pages = input.nextInt();
        isbn = input.next();

        System.out.printf("책 제목 : %s\n", title);
        System.out.printf("가격 : %d\n", price);
        System.out.printf("출판사 : %s\n", publisher);
        System.out.printf("작가 : %s\n", author);
        System.out.printf("페이지 수 : %d\n", pages);
        System.out.printf("ISBN : %s\n", isbn);
    }
}

package designPattern.iterator;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        BookShelf bookShelf = new BookShelf(4);
        bookShelf.appendBook(new Book("Around the world in 80 days"));
        bookShelf.appendBook(new Book("Bible"));
        bookShelf.appendBook(new Book("Cinderella"));
        bookShelf.appendBook(new Book("Daddy-Long-Legs"));

        // 명시적으로 Iterator 사용
        Iterator<Book> it = bookShelf.iterator();
        while (it.hasNext()) {
            Book book = it.next();
            System.out.println(book.getName());
        }
        System.out.println();

        // [!] 주의
        while (it.hasNext()) {
            Book book = it.next();
            System.out.println(book.getName());
        }
        // 아무것도 출력되지 않음
        // 한번 순회한 iterator로 다시 순회할 수 없음 - iterator는 일회용
        // 순회할 때마다 iterator를 새로 만들어야 함

        // 확장된 for문 사용
        for (Book book : bookShelf) {
            System.out.println(book.getName());
        }
        System.out.println();
    }
}

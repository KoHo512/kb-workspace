package practice_0423.Inheritance.prob2;

public class BookMgr {
    private Book[] booklist;

    public BookMgr(Book[] booklist) {
        this.booklist = booklist;
    }

    public void printBooklist(){
        for (Book book : booklist) {
            System.out.println(book.getTitle());
        }
    }

    public void printTotalPrice(){
        int total = 0;
        for (Book book : booklist) {
            total += book.getPrice();
        }

        System.out.printf("전체 책 가격의 합 : %d", total);
    }
}

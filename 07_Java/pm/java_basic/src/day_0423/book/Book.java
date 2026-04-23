package day_0423.book;

public class Book {
    private String title;
    private int price;
    private String company;
    private String author;
    private int page;
    private String isbn;

    public Book() {
    }

    public Book(String title, int price, String company, String author, int page, String isbn) {
        this.title = title;
        this.price = price;
        this.company = company;
        this.author = author;
        this.page = page;
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}

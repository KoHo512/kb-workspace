package designPattern.iterator;

public class Book {
    private String name;

    public Book(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

//public record Book(String name) {}
// 으로 선언도 가능 - read-only
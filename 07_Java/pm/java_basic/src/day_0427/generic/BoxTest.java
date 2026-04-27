package day_0427.generic;

class Box<T> {
    private T content;

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public boolean compare(Box<T> other) {
        boolean result = content.equals(other.content);

        return result;
    }
}

class Doll {
    String type = "곰인형";
}

public class BoxTest {
    public static void main(String[] args) {
        Doll doll = new Doll();
        Box<Doll> box = new Box<Doll>();

        box.setContent(doll);
        System.out.println(box.getContent().type);  // 곰인형
    }
}

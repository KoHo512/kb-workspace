package day_0427.generic.box;

public class BoxTest {
    public static void main(String[] args) {
        Box box1 = new Box();
        Box box2 = new Box();
        Box box3 = new Box();

        box1.content = 100;
        box2.content = "100";
        box3.content = 100;

        boolean r1 = box1.compare(box2);
        System.out.println(r1); // false

        boolean r2 = box1.compare(box3);
        System.out.println(r2); // true
    }
}

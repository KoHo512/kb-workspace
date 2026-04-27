package day_0427.generic.box;

class FruitBox<T, U> {
    // 독립적으로운영되는 제네릭 메서드
    public <T, U> void printBox(T x, U y) {
        // 해당 매개변수의 타입 출력
        System.out.println(x.getClass().getSimpleName());
        System.out.println(y.getClass().getSimpleName());
    }
}

public class FruitBoxTest {
    public static void main(String[] args) {
        FruitBox<Integer, Long> box1 = new FruitBox<>();

        // 인스턴스화에 지정된 타입 파라미터 <Integer, Long>
        box1.printBox(1, 1);

        // 하지만 제네릭 메서드에 다른 타입 파라미터를 지정하면 독립적으로 운용 된다.
        box1.<String, Double>printBox("hello", 5.55);
        box1.printBox("hello", 5.55); // 생략 가능
    }
}

package day_0427.generic;

class Sample1<T> {
    private T value; // 멤버 변수 val의 타입은 T 이다.

    // T 타입의 값 val을 반환한다.
    public T getValue() {
        return value;
    }

    // T 타입의 값을 멤버 변수 val에 대입한다.
    public void setValue(T value) {
        this.value = value;
    }
}

public class SampleTest {
    public static void main(String[] args) {
        // 정수형을 다루는 제네릭 클래스
        Sample1<Integer> s1 = new Sample1<>();
        s1.setValue(1);
        System.out.println(s1.getValue());

        // 실수형을 다루는 제네릭 클래스
        Sample1<Double> s2 = new Sample1<>();
        s2.setValue(1.0);
        System.out.println(s2.getValue());

        // 문자열을 다루는 제네릭 클래스
        Sample1<String> s3 = new Sample1<>();
        s3.setValue("1");
        System.out.println(s3.getValue());
    }
}

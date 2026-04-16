package day01.section02.variable;

public class VariableExchangeExample {
    public static void main(String[] args) {
        // 정수형 변수 x에 3 대입
        int x = 3;

        // 정수형 변수 y에 5 대입
        int y = 5;

        // 현재 x, y 값 출력
        System.out.println("x : " + x + ", y : " + y);

        // x의 값과 y의 값을 교환한 후 결과 출력
        int tmp;
        tmp = x;
        x = y;
        y = tmp;
        System.out.println("x : " + x + ", y : " + y);
    }
}

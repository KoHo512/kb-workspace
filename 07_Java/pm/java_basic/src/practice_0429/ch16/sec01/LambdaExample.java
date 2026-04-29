package practice_0429.ch16.sec01;

public class LambdaExample {
    public static void main(String[] args) {
        Calculable add = (x, y) -> System.out.println("result : " + (x + y));
        Calculable sub = (x, y) -> System.out.println("result : " + (x - y));

        action(add);
        action(sub);
    }

    public static void action(Calculable calculable) {
        int x = 10;
        int y = 4;
        calculable.calculate(x, y);
    }
}

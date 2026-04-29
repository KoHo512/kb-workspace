package day_0429.lambda;

public class Main {
    public static void main(String[] args) {
        Calculator add = (x, y) -> x + y;
        Calculator sub = (x, y) -> x - y;
        Calculator mult = (x, y) -> x * y;

        int result = add.calc(10, 20);
        System.out.println(result);

        result = sub.calc(20, 10);
        System.out.println(result);

        result = mult.calc(30, 40);
        System.out.println(result);
    }
}

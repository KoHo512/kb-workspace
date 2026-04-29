package practice_0429.ch16.sec04;

public class LambdaExample {
    public static void main(String[] args) {
        Person person = new Person();

        person.action((x, y) -> x + y);

        person.action(LambdaExample::sum);

    }

    public static double sum(double x, double y) {
        return x + y;
    }
}

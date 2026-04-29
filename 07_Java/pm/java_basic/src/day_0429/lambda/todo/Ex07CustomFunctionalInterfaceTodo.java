package day_0429.lambda.todo;

public class Ex07CustomFunctionalInterfaceTodo {
    @FunctionalInterface
    interface DiscountPolicy {
        int discount(int price);
    }

    public static void main(String[] args) {
        int price = 10000;

        // TODO: 10% 할인 정책을 람다식으로 작성하세요.
        DiscountPolicy policy = p -> p - p / 10;

        System.out.println("할인 후 가격: " + policy.discount(price));
    }
}

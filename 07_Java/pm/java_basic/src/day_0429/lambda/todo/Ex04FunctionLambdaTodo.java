package day_0429.lambda.todo;

import java.util.function.Function;

/**
 * Function<T, R> : T 타입의 값을 받아 R 타입으로 변환하면 함수형 인터페이스
 */

public class Ex04FunctionLambdaTodo {
    static class User {
        String name;
        int age;

        User(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    public static void main(String[] args) {
        User user = new User("홍길동", 25);

        // TODO: Function<User, String>을 람다식으로 작성하여 "홍길동(25세)" 형태로 변환하세요.
        Function<User, String> userFormatter = u -> u.name + "(" + u.age + "세)";

        System.out.println(userFormatter.apply(user));
    }
}

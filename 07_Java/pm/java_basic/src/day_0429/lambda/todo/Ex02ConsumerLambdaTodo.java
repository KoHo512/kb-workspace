package day_0429.lambda.todo;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Consumer<T> : 매개변수 1개를 전달받고 반환값이 없는 함수형 인터페이스
 * 데이터를 받아 소비/처리하는 용도
 */

public class Ex02ConsumerLambdaTodo {
    public static void main(String[] args) {
        List<String> students = Arrays.asList("김자바", "이람다", "박스트림");

        // TODO: Consumer<String>을 람다식으로 작성하여 각 학생 이름 앞에 "학생: "을 붙여 출력하세요.
        Consumer<String> printer = student -> System.out.println("학생 : " + student);

        for (String student : students) {
            printer.accept(student);
        }
    }
}

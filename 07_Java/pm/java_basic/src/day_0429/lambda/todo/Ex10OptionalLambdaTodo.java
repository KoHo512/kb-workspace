package day_0429.lambda.todo;

import java.util.Optional;

/**
 * Optional<T> : null일 수 있는 값을 안전하게 다루기 위한 컨테이너
 * ofNullable() : 값이 null이어도 안전하게 Optional 객체 생성하여 처리
 * orElse() : 값이 없을 때 사용할 기본값 설정
 */

public class Ex10OptionalLambdaTodo {
    public static void main(String[] args) {
        String email = null;
//        String email = "null@example.com";

        // TODO: Optional과 람다를 사용하여 email이 null이면 "이메일 없음"을 출력하세요.
        String result = Optional.ofNullable(email).map(value -> "이메일 : " + value).orElse("이메일 없음");

        System.out.println(result);
    }
}

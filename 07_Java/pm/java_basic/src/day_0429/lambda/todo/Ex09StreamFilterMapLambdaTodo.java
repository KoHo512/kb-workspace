package day_0429.lambda.todo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Stream : 컬렉션 데이터를 선언형으로 처리할 수 있게 해주는 API
 * filter() : 조건에 맞는 데이터만 통과시키는 메소드 - Predicate<T>
 * map() : 데이터를 다른 형태로 변환 - Function<T, R> 사용
 * collect() : Stream 처리 결과를 List, Set, Map 형태로 수집하는 메소드
 */

public class Ex09StreamFilterMapLambdaTodo {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("kim", "lee", "park", "choi");

        // TODO: 이름 길이가 3 이상인 값만 필터링하고 대문자로 변환하여 List로 수집하세요.
        List<String> result = names.stream()
                .filter(name -> name.length() >= 3)
                .map(name -> name.toUpperCase())
                .collect(Collectors.toList());

        System.out.println(result);
    }
}

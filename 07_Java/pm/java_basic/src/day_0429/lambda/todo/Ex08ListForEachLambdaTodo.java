package day_0429.lambda.todo;

import java.util.Arrays;
import java.util.List;

/**
 * Iterable.forEach() : 내부적으로 Consumer<T>
 * 리스트의 각 요소를 처리하는 로직을 람다식으로 전달 가능
 */

public class Ex08ListForEachLambdaTodo {
    public static void main(String[] args) {
        List<String> menus = Arrays.asList("아메리카노", "라떼", "모카");

        // TODO: forEach와 람다식을 사용하여 모든 메뉴를 출력하세요.
        menus.forEach(menu -> System.out.println("메뉴 : " + menu));
    }
}

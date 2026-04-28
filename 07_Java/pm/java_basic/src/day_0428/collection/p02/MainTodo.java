package day_0428.collection.p02;

import java.util.ArrayList;
import java.util.List;

public class MainTodo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        // TODO 1: 인덱스 1의 값을 "Java"로 변경
        list.set(1, "Java");

        // TODO 2: 인덱스 0 요소 삭제
        list.remove(0);

        // TODO 3: 남은 요소 출력
        for (String l : list) {
            System.out.println(l);
        }
    }
}

package day_0428.collection.p04;

import java.util.HashMap;
import java.util.Map;

public class MainTodo {
    public static void main(String[] args) {
        // TODO 1: Map<String, Integer> 생성
        Map<String, Integer> scores = new HashMap<>();

        // TODO 2: 국어 90, 영어 80, 수학 95 저장
        scores.put("국어", 90);
        scores.put("영어", 80);
        scores.put("수학", 95);

        System.out.println(scores.size());  // 3

        // TODO 3: 영어 점수 출력
        Integer engScore = scores.get("영어");
        System.out.println(engScore);   // 80
    }
}

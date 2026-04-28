package day_0428.collection.p01;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainTodo {
    public static void main(String[] args) {
        // TODO 1: List<String> 생성
        List<String> subject = new ArrayList<>();

        // TODO 2: "Java", "Spring", "Vue" 추가
        subject.add("Java");
        subject.add("Spring");
        subject.add("Vue");

        // TODO 3: foreach 전체 요소 출력
//        subject.forEach(s -> System.out.println(s));

//        for (String s : subject) {
//            System.out.println(s);
//        }

        Iterator iterator = subject.iterator();
        while (iterator.hasNext()) {
            // Iterator는 Object를 반환
//            String result = iterator.next().toString();
            String result = (String) iterator.next();
            System.out.println(result);
        }
    }
}

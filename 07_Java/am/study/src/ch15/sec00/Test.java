package ch15.sec00;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Test");

        List<String> list2 = List.of("Test1", "Test2", "Test3");
        System.out.println(list2);  // [Test1, Test2, Test3]

        // List.of()는 read-only => 추가/삭제 불가능 (UnsupportedOperationException 예외 발생)
//        list2.add("Test4");
//        System.out.println(list2);

        Map<String, String> map = Map.of("k1", "v1", "k2", "v2");
        System.out.println(map);    // {k2=v2, k1=v1}
    }
}

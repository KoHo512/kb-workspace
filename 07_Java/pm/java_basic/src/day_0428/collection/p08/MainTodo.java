package day_0428.collection.p08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MainTodo {
    public static void main(String[] args) {
        // TODO 1: 정수 리스트 생성 후 30, 10, 20 추가
        List<Integer> list = new ArrayList<>();
        list.add(30);
        list.add(10);
        list.add(20);

        // TODO 2: 오름차순 정렬 후 출력
        // 1. Arrays.sort() 이용해 정렬
        //
        Integer[] array = list.toArray(new Integer[0]);
        Arrays.sort(array);
        System.out.println(Arrays.toString(array)); // [10, 20, 30]
    }
}

package day_0428.collection.p07;

import java.util.LinkedList;
import java.util.Queue;

public class MainTodo {
    public static void main(String[] args) {
        // TODO 1: Queue<String> 생성
        Queue<String> queue = new LinkedList<>();

        // TODO 2: offer로 3개 추가
        queue.offer("작업 1");
        queue.offer("작업 2");
        queue.offer("작업 3");

        // TODO 3: poll 하며 출력
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}

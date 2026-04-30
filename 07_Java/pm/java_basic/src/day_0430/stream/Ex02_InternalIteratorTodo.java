package day_0430.stream;

import java.util.List;

public class Ex02_InternalIteratorTodo {
    public static void main(String[] args) {
        List<String> names = List.of("홍길동", "신용권", "감자바", "람다식", "박병렬");

        // TODO 1: 일반 stream의 forEach로 이름을 출력하세요.
        names.stream().forEach(name -> System.out.println("일반 스트림 : " + name));

        System.out.println();

        // TODO 2: parallelStream의 forEach로 이름과 현재 스레드명을 출력하세요.
        names.parallelStream().forEach(name -> System.out.println("병렬 스트림 : " + name + " : " + Thread.currentThread().getName()));
    }
}

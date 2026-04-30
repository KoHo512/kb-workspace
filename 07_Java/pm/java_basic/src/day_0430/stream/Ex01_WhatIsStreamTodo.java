package day_0430.stream;

import java.util.HashSet;
import java.util.Set;

public class Ex01_WhatIsStreamTodo {
    public static void main(String[] args) {
        Set<String> names = new HashSet<>();
        names.add("홍길동");
        names.add("신용권");
        names.add("감자바");

        // TODO 1: names에서 스트림을 얻고 forEach로 이름을 출력하세요.
        names.stream().distinct().forEach(name-> System.out.println(name));
    }
}

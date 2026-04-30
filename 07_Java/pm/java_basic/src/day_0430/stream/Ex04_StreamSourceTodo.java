package day_0430.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex04_StreamSourceTodo {
    public static void main(String[] args) throws Exception {
        List<String> names = List.of("홍길동", "신용권", "김미나");
        String[] arr = {"A", "B", "C"};
        Path path = Path.of("src/day_0430/stream/student/todo/resources/products.txt");
//        Path path = Path.of(".");   // 프로젝트의 디폴트 위치 (src)

        // TODO 1: 컬렉션 스트림으로 names 출력
//        names.stream().forEach(name -> System.out.println(name));
        names.stream().forEach(System.out::println);

        // TODO 2: 배열 스트림으로 arr 출력
//        Arrays.stream(arr).forEach(a -> System.out.println(a));
        Arrays.stream(arr).forEach(System.out::println);

        // TODO 3: IntStream.rangeClosed(1, 5) 출력
        IntStream.rangeClosed(1, 5).forEach(System.out::print);
        System.out.println();

        // TODO 4: Files.lines(path)로 파일 내용을 출력하고 리소스를 닫으세요.
        try (Stream<String> lines = Files.lines(path)) {
            lines.forEach(System.out::println);
        }
    }
}

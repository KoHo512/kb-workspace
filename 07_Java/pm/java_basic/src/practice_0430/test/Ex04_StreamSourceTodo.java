package practice_0430.test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex04_StreamSourceTodo {
    public static void main(String[] args) throws Exception {
        List<String> categories = List.of("PC", "LIFE", "FOOD");
        String[] keywords = {"keyboard", "mouse", "monitor"};
        Path path = Path.of("src/practice_0430/test/resources/products.csv");

        // TODO 1: categories 컬렉션 스트림을 출력하세요.
        System.out.println("categories 컬렉션 스트림");
        categories.stream().forEach(System.out::println);

        System.out.println();

        // TODO 2: keywords 배열 스트림을 출력하세요.
        System.out.println("keywords 배열 스트림");
        Arrays.stream(keywords).forEach(System.out::println);

        System.out.println();

        // TODO 3: IntStream.rangeClosed(1, 7)로 1일부터 7일까지 출력하세요.
        IntStream.rangeClosed(1, 7).forEach(i -> System.out.print(i + "일 "));

        System.out.println();
        System.out.println();

        // TODO 4: Files.lines(path)를 try-with-resources로 열고 CSV 내용을 출력하세요.
        try(Stream<String> lines = Files.lines(path)) {
            lines.forEach(line-> System.out.println(line));
        } catch (IOException e) {}
    }
}

package day_0430.stream;

import day_0430.stream.common.Student;

import java.util.Arrays;
import java.util.List;

public class Ex06_MappingTodo {
    public static void main(String[] args) {
        List<Student> students = List.of(new Student("홍길동", "남", 85), new Student("김수영", "여", 92));
        List<String> sentences = List.of("this is java", "i am a developer");
        int[] numbers = {1, 2, 3, 4, 5};

        // TODO 1: 학생 객체를 점수 int 스트림으로 변환해 출력
        students.stream()
                .mapToInt(Student::getScore)
                .forEach(System.out::println);

        System.out.println();

        // TODO 2: numbers를 double 스트림으로 변환해 출력
        Arrays.stream(numbers)
                .asDoubleStream()
                .forEach(System.out::println);

        System.out.println();

        // TODO 3: sentences를 단어 스트림으로 flatMap 처리해 출력
        sentences.stream()
                .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .forEach(System.out::println);
    }
}

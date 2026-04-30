package day_0430.stream;

import day_0430.stream.common.Student;

import java.util.List;

public class Ex03_PipelineTodo {
    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("홍길동", "남", 40),
                new Student("신용권", "남", 80),
                new Student("유미선", "여", 90)
        );

        // TODO 1: stream -> mapToInt(Student::getScore) -> average -> orElse(0.0)로 평균을 구하세요.
        double avg = students.stream()
                .mapToInt(Student::getScore)
                .average().orElse(0.0);

        System.out.println("평균 : " + avg);
    }
}

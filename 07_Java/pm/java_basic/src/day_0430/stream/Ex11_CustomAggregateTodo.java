package day_0430.stream;

import day_0430.stream.common.Student;

import java.util.List;

public class Ex11_CustomAggregateTodo {
    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("홍길동", "남", 92),
                new Student("신용권", "남", 95),
                new Student("감자바", "남", 88)
        );

        // TODO 1: mapToInt + sum으로 점수 합계를 구하세요.
        int sum1 = students.stream().mapToInt(Student::getScore).sum();
        System.out.println(sum1);

        // TODO 2: map + reduce(0, (a, b) -> a + b)로 점수 합계를 구하세요.
        int sum2 = students.stream().map(Student::getScore).reduce(0, (a, b) -> a + b);
        System.out.println(sum2);
    }
}

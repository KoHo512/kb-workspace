package day_0428.sort.student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudentSortExample {
    public static void run() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("김철수", 80, 22));
        students.add(new Student("이영희", 95, 20));
        students.add(new Student("박민수", 70, 21));
        students.add(new Student("최지우", 95, 19));
        students.add(new Student(null, 88, 23));

        System.out.println("원본 데이터");
        print(students);

        System.out.println("\nComparable 사용: 점수 오름차순");
        Collections.sort(students);
        print(students);

        System.out.println("\nComparator 사용: 점수 내림차순");
        students.sort(Comparator.comparingInt(Student::getScore).reversed());
        print(students);

        System.out.println("\nComparator 사용: 점수 내림차순, 점수가 같으면 나이 오름차순");
        students.sort(
                Comparator.comparingInt(Student::getScore).reversed()
                        .thenComparingInt(Student::getAge)
        );
        print(students);

        System.out.println("\nComparator 사용: 이름 오름차순, null은 마지막");
        students.sort(
                Comparator.comparing(
                        Student::getName,
                        Comparator.nullsLast(String::compareTo)
                )
        );
        print(students);
    }

    private static void print(List<Student> students) {
        for (Student student : students) {
            System.out.println(student);
        }
    }
}

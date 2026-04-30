package day_0430.stream;

import day_0430.stream.common.Student;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Ex12_CollectingTodo {
    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("홍길동", "남", 82),
                new Student("김수영", "여", 87),
                new Student("감자바", "남", 91),
                new Student("오해영", "여", 93)
        );

        // TODO 1: 남학생만 List로 수집
//        List<Student> maleStudents = students.stream().filter(stu -> stu.getSex().equals("남")).collect(Collectors.toList());
        List<Student> maleStudents = students.stream().filter(stu -> stu.getSex().equals("남")).toList();

        // TODO 2: 이름을 key, 점수를 value로 Map 수집
        Map<String, Integer> scoreMap = students.stream().collect(Collectors.toMap(Student::getName, Student::getScore));

        // TODO 3: 성별 기준 groupingBy로 그룹핑
        Map<String, List<Student>> bySex = students.stream()
                .collect(Collectors.groupingBy(Student::getSex));

        // TODO 4: 성별 기준 평균 점수 Map을 수집
        Map<String, Double> avgMap = students.stream()
                .collect(Collectors.groupingBy(Student::getSex, Collectors.averagingDouble(Student::getScore)));

        System.out.println("Todo 1 : " + maleStudents);
        System.out.println("Todo 2 : " + scoreMap);
        System.out.println("Todo 3 : " + bySex);
        System.out.println("Todo 4 : " + avgMap);
    }
}

package day_0428.collection.p09;

import java.util.ArrayList;
import java.util.List;

class StudentTodo {
    String name;
    int score;

    // TODO 1: 생성자 작성
    public StudentTodo(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

public class MainTodo {
    public static void main(String[] args) {
        // TODO 2: StudentTodo 리스트 생성
        List<StudentTodo> studentTodoList = new ArrayList<>();

        // TODO 3: 객체 3개 추가
        studentTodoList.add(new StudentTodo("홍길동", 90));
        studentTodoList.add(new StudentTodo("김길동", 80));
        studentTodoList.add(new StudentTodo("최길동", 70));

        // TODO 4: 평균 점수 출력
        int total = 0;
        for (StudentTodo studentTodo : studentTodoList) {
            total += studentTodo.score;
        }
        System.out.printf("평균 : %d", (total / studentTodoList.size()));
    }
}

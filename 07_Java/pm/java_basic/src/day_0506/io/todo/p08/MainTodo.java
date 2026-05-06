package day_0506.io.todo.p08;

import java.io.*;

// TODO 1: PersonTodo 클래스를 Serializable 구현으로 작성
// name 필드와 생성자 포함
class PersonTodo implements Serializable {
    private String name;
    private int age;

    public PersonTodo() {
    }

    public PersonTodo(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

public class MainTodo {
    public static void main(String[] args) throws Exception {
        // TODO 2: PersonTodo 객체를 person.dat에 저장
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:/Temp/person.dat"))) {
            oos.writeObject(new PersonTodo("홍길동", 30));
        }

        // TODO 3: person.dat에 저장한 데이터 출력
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:/Temp/person.dat"))) {
            PersonTodo person = (PersonTodo) ois.readObject();

            String name = person.getName();
            int age = person.getAge();

            System.out.printf("이름 : %s, 나이 : %d", name, age);
        }
    }
}

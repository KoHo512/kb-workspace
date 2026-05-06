package day_0506.io.todo.p02;

import java.io.FileWriter;

public class MainTodo {
    public static void main(String[] args) throws Exception {
        // TODO 1: FileWriter로 test.txt에 "Java" 쓰기
        FileWriter fw = new FileWriter("C:/Temp/todo/test4.txt");
        fw.write("Java");

        // TODO 2: close 호출
        fw.close();
    }
}

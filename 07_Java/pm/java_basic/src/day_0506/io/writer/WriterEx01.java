package day_0506.io.writer;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriterEx01 {
    public static void main(String[] args) {
        try (Writer wt = new FileWriter("C:/Temp/test3.txt")) {
            wt.write("A");

            int ch = 65;
            wt.write(ch);

            char[] data = {'D', 'E', 'F'};
            wt.write(data);

            String str = "Java";
            wt.write(str);

            wt.flush();
        } catch (IOException e) {
            System.out.println("파일 쓰기 중 오류 발생");
        }
    }
}

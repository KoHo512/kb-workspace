package ch18.sec02.exam01;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteExample2 {
    public static void main(String[] args) {
        // finally에 os.close() 작성하지 않아도 파일을 닫아줌
        try (OutputStream os = new FileOutputStream("C:/temp/test1.db")) {

            byte a = 10;
            byte b = 20;
            byte c = 30;

            os.write(a);
            os.write(b);
            os.write(c);

            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package ch18.sec02.exam01;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteExample {
    public static void main(String[] args) {
        try {
            OutputStream os = new FileOutputStream("C:/temp/test1.db");

            byte a = 10;
            byte b = 20;
            byte c = 30;

            os.write(a);
            os.write(b);
            os.write(c);

            os.flush();
//            os.close(); // 예외 발생 시 이 코드에 도달하지 못함 - 파일이 안 닫힘
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
//            os.close(); // close()도 try-catch로 감싸야 함
        }
        // => 이런 복잡함을 해결하기 위해 try with resource 사용
    }
}

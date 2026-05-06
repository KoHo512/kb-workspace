package day_0506.io.reader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ReaderEx01 {
    public static void main(String[] args) {
        Reader reader = null;
        try {
            // 1 : 한 문자씩 읽어와서 콘솔 출력
            reader = new FileReader("C:/Temp/test3.txt");

            while (true) {
                int data = reader.read();

                if (data == -1) break;

                System.out.print((char) data);
            }
            reader.close();

            System.out.println();

            // 2 : 문자 배열에 담아서 콘솔 출력
            reader = new FileReader("C:/Temp/test3.txt");
            char[] chars = new char[1024];

            while (true) {
                int data = reader.read(chars);
                if (data == -1) break;

                // 비어있는 배열까지 출력
//                for (char a : chars) {
//                    System.out.print(a);
//                }

                for (int i = 0; i < data; i++) {
                    System.out.print(chars[i]);
                }
            }

            reader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

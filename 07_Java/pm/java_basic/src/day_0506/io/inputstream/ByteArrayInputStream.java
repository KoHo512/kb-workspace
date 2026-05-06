package day_0506.io.inputstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ByteArrayInputStream {
    public static void main(String[] args) {
        try (InputStream is = new FileInputStream("C:/Temp/test2.txt")) {
            byte[] data = new byte[100];

            while (true) {
                int number = is.read(data);

                if (number == -1) break;

                for (int i = 0; i < number; i++) {
                    System.out.println(data[i]);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

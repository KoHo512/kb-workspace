package day_0506.io.inputstream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteEx01 {
    public static void main(String[] args) {
        try {
            OutputStream os = new FileOutputStream("C:/Temp/test.txt");
            byte c1 = 1;
            byte c2 = 2;
            byte c3 = 3;

            os.write(c1);
            os.write(c2);
            os.write(c3);

            os.flush();
            os.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

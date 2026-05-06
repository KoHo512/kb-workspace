package day_0506.io.inputstream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ByteArrayOutputStream {
    public static void main(String[] args) {
        try (OutputStream os = new FileOutputStream("C:/Temp/test2.txt");) {

            byte[] data = {1, 2, 3};

            os.write(data);

            os.flush();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

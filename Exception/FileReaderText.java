package Exception;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderText {
    public static void main(String[] args) {
        try (FileReader reader = new FileReader("src/Exception/test.txt");
             FileWriter writer = new FileWriter("src/Exception/testCopy.txt")) {
            while (reader.ready()) {
                writer.write(reader.read());
            }
        } catch (RuntimeException | IOException e) {
            System.out.println("catch exception: " + e.getClass().getSimpleName());
        }
        try {
            System.out.println("Test operation");
        } finally {
            System.out.println("Finally operation");
        }

    }


}









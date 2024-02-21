package Play_Toy;
//java.util.PriorityQueue;
//public class Toy {
//    private int id;
//    private String name;
//    private int weight;
//
//    public Toy(int id, String name, int weight) {
//        this.id = id;
//        this.name = name;
//        this.weight = weight;
//    }
//
//
//}

import java.io.BufferedWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Toy {
    private int id;
    private String name;
    private int weight;

    public Toy(int id, String name, int weight) {
        this.id = id;
        this.name = name;
        this.weight = weight;
    }
    public static void main(String[] args) throws Exception {

        Path logFile = Paths.get("toy_weight.log");
        if (Files.notExists(logFile)) {
            Files.createFile(logFile);
        }

        try (BufferedWriter writer =
                     Files.newBufferedWriter(logFile, StandardCharsets.UTF_8,
                             StandardOpenOption.WRITE)) {

            for (int i = 0; i < 10; i++) {
                writer.write(String.format("Message %s%n", i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
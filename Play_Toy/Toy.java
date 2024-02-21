package Play_Toy;

import java.io.BufferedWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.PriorityQueue;

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
        int[] ids = {1, 2, 3};
        int[] frequencies = {3, 2, 6};
        String[] names = {"Toy 1", "Toy 2", "Toy 3"};

        PriorityQueue<Toy> toy = new PriorityQueue<>();
        for (int i = 0; i < ids.length; i++) {
            toy.add(new Toy(ids[i], names[i], frequencies[i]));
        }

        Path logFile = Paths.get("toy_weight.log");
        if (Files.notExists(logFile)) {
            Files.createFile(logFile);
        }

        try (BufferedWriter writer = Files.newBufferedWriter(logFile, StandardCharsets.UTF_8, StandardOpenOption.WRITE)) {
            for (Toy t : toy) {
                writer.write(String.format("Toy id: %d, Name: %s, Weight: %d%n", t.id, t.name, t.weight));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
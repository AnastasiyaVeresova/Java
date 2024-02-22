package Play_Toy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Random;

public class Toy implements Comparable<Toy> {
    private int id;
    private String name;
    private int weight;

    public Toy(int id, String name, int weight) {
        this.id = id;
        this.name = name;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Toy other) {
        return Integer.compare(this.weight, other.weight);
    }

    public static void main(String[] args) throws IOException {


        PriorityQueue<Toy> toySet = generateSet(10, 5);
        for (Toy t : toySet) {
            t.weight += new Random().nextInt(10);
        }

        Path logfile = Paths.get("toy_weight.log");
        try (BufferedWriter writer = Files.newBufferedWriter(logfile, StandardCharsets.UTF_8, StandardOpenOption.WRITE)) {
            for (Toy t : toySet) {
                writer.write(String.format("Toy id: %d, name: %s, weight: %d%n", t.getId(), t.getName(), t.getWeight()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static PriorityQueue<Toy> generateSet(int n, int size) throws IOException {
        PriorityQueue<Toy> toySet = new PriorityQueue<>();
        int[] ids = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ArrayList<String> names = readNamesFromFile("toy_names.txt");
        int[] frequencies = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            toySet.add(new Toy(ids[i], names.get(rand.nextInt(names.size())), frequencies[i]));
        }
        return toySet;
    }

    public static ArrayList<String> readNamesFromFile(String fileName) {
        ArrayList<String> names = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                names.add(line.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return names;
    }
}
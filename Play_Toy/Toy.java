package Play_Toy;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
// Робот,Кукла,Конструктор,Машинка,Кубик,Тигр,Пеликан,Домик,Формочки,Лодка,Корабль,
public class Toy implements Comparable<Toy> {
    private int id;
    private String name;
    private int weight;
    public Toy(int id, String name, int weight) throws IOException {
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
    public static ArrayList<String> readNamesFromFile(String fileName) {
        ArrayList<String> names = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(fileName), StandardCharsets.UTF_8)) {
            String line = reader.readLine();
            String[] nameArray = line.split(",");
            names.addAll(Arrays.asList(nameArray));
        } catch (IOException e) {
            System.out.printf("Ошибка при чтении файла: %s%n", e.getMessage());
        }
        return names;
    }
    public static int getRandomIdFromQueue(PriorityQueue<Toy> sharedQueue) {
        List<Toy> toyList = new ArrayList<>(sharedQueue);
        Random random = new Random();
        int randomIndex = random.nextInt(toyList.size());
        return toyList.get(randomIndex).getId();
    }
    @Override
    public String toString() {
        return getId() + ", " + getName() + ", " + getWeight();
    }
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1 - Ввести данные самостоятельно. Файл будет перезаписан полностью\n2 - Использовать сгенерированные массивы\n3 - " +
                "Добавить" +
                " еще игрушек в файл");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                List<Toy> sharedQueueInput;
                try (BufferedWriter fileWriter = Files.newBufferedWriter(Paths.get("WeightOfToys.log"), StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)) {
                    System.out.println("Введите \"id наименование вес через пробел\". Введите 'exit' для выхода.");
                    sharedQueueInput = new ArrayList<>();
                    while (true) {
                        String input = scanner.nextLine();
                        if (input.equals("exit")) {
                            break;
                        }
                        String[] data = input.split(" ");
                        if (data.length != 3) {
                            System.out.println("Некорректный ввод. Ожидается id наименование вес.");
                            continue;
                        }
                        try {
                            int id = Integer.parseInt(data[0]);
                            String name = data[1];
                            int weight = Integer.parseInt(data[2]);
                            sharedQueueInput.add(new Toy(id, name, weight));
                        } catch (NumberFormatException e) {
                            System.out.println("Некорректный ввод. Ожидается id наименование вес: " + e.getMessage());
                        }
                    }
                    for (Toy t : sharedQueueInput) {
                        fileWriter.write(String.format("%d %s %d%n", t.getId(), t.getName(), t.getWeight()));
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                scanner.close();
                int[] inputId;
                ArrayList<String> inputNames = new ArrayList<>();
                int[] inputWeights;
                ArrayList<Integer> idList = new ArrayList<>();
                ArrayList<Integer> weightList = new ArrayList<>();
                PriorityQueue<Toy> inputSharedQueue = new PriorityQueue<>();
                try (BufferedReader br = new BufferedReader(new FileReader("WeightOfToys.log"))){
                    String line;
                    while ((line = br.readLine()) != null) {
                        String[] parts = line.split(" ");
                        idList.add(Integer.parseInt(parts[0]));
                        inputNames.add(parts[1]);
                        weightList.add(Integer.parseInt(parts[2]));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

//                } finally {
//                    if (br != null) {
//                        try {
//                            br.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//

                inputId = idList.stream().mapToInt(Integer::intValue).toArray();
                inputWeights = weightList.stream().mapToInt(Integer::intValue).toArray();
                for (int i = 0; i < inputId.length; i++) {
                    inputSharedQueue.add(new Toy(inputId[i], inputNames.get(i), inputWeights[i]));
                }
                List<Toy> inputSortedToys = new ArrayList<>(inputSharedQueue);
                Collections.sort(inputSortedToys);
                try (BufferedWriter bw = Files.newBufferedWriter(Paths.get("WeightOfToys.log"), StandardCharsets.UTF_8, StandardOpenOption.CREATE,
                        StandardOpenOption.TRUNCATE_EXISTING)) {
                    for (Toy t : inputSortedToys) {
                        bw.write(String.format("%d %s %d%n", t.getId(), t.getName(), t.getWeight()));
                    }
                } catch (IOException e) {
                    System.out.printf("Ошибка при создании файла: %s%n", e.getMessage());
                }
                System.out.println("Случайный id: " + getRandomIdFromQueue(inputSharedQueue));
                break;
            case 2:
                PriorityQueue<Toy> sharedQueue = new PriorityQueue<>();
                int size = 10;
                int upperBound = 10;
                int[] ids = new int[size];
                for (int i = 0; i < size; i++) {
                    ids[i] = i + 1;
                }
//                int[] ids = new Random().ints(size, 0, upperBound).toArray();
                int[] frequencies = new Random().ints(size, 0, upperBound).toArray();
//                int[] ids = {1, 2, 3};
//                int[] frequencies = {2, 2, 6};
                ArrayList<String> names = readNamesFromFile("NameOfToys.txt");
                for (int i = 0; i < ids.length; i++) {
                    sharedQueue.add(new Toy(ids[i], names.get(new Random().nextInt(names.size())), frequencies[i]));
                }
                List<Toy> sortedToys = new ArrayList<>(sharedQueue);
                Collections.sort(sortedToys);
                try (BufferedWriter bw = Files.newBufferedWriter(Paths.get("WeightOfToys.log"), StandardCharsets.UTF_8, StandardOpenOption.CREATE,
                        StandardOpenOption.TRUNCATE_EXISTING)) {
                    for (Toy t : sortedToys) {
                        bw.write(String.format("%d %s %d%n", t.getId(), t.getName(), t.getWeight()));
                    }
                } catch (IOException e) {
                    System.out.printf("Ошибка при создании файла: %s%n", e.getMessage());
                }
                System.out.println("Случайный id: " + getRandomIdFromQueue(sharedQueue));
                break;
            case 3:
                if (Files.size(Paths.get("WeightOfToys.log")) > 0) {
                    System.out.println("Файл не пустой. Введите данные для новых игрушек:");
                    try (BufferedWriter fileWriter = Files.newBufferedWriter(Paths.get("WeightOfToys.log"), StandardCharsets.UTF_8, StandardOpenOption.APPEND)) {
                        while (true) {
                            String input = scanner.nextLine();
                            if (input.equals("exit")) {
                                break;
                            }
                            String[] data = input.split(" ");
                            if (data.length != 3) {
                                System.out.println("Некорректный ввод. Ожидается id наименование вес.");
                                continue;
                            }
                            try {
                                int id = Integer.parseInt(data[0]);
                                String name = data[1];
                                int weight = Integer.parseInt(data[2]);
                                fileWriter.write(String.format("%d %s %d%n", id, name, weight));
                            } catch (NumberFormatException e) {
                                System.out.println("Некорректный ввод. Ожидается id наименование вес: " + e.getMessage());
                            }
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    System.out.println("Файл пустой. Добавьте данные с использованием пункта 1.");
                }
                break;
        }
    }
}
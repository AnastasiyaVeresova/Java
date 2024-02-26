package Play_Toy;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.DecimalFormat;
import java.util.*;
public class Toy implements Comparable<Toy> {
    private int id;
    private String name;
    private double weight;

    private int quantity;

    public Toy(int id, String name, int quantity, double weight) throws IOException {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.weight = weight;

    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }
    public double getWeight() {
        return weight;
    }
    @Override
    public int compareTo(Toy other) {
        return Double.compare(this.weight, other.weight);
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
        return getId() + " " + getName() + " " + getQuantity() + " " + getWeight();
    }
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1 - Ввести данные самостоятельно. Файл будет перезаписан полностью\n2 - Использовать сгенерированные массивы\n3 - " +
                "Добавить" +
                " еще игрушек в файл\n4 - провести розыгрыш");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                List<Toy> sharedQueueInput = new ArrayList<>();;
                try (BufferedWriter fileWriter = Files.newBufferedWriter(Paths.get("WeightOfToys.log"), StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)) {
                    System.out.println("Введите \"id наименование частоту количество через пробел\". Введите 'exit' для выхода.");
                    while (true) {
                        String input = scanner.nextLine();
                        if (input.equals("exit")) {
                            break;
                        }
                        String[] data = input.split(" ");
                        if (data.length != 4) {
                            System.out.println("Некорректный ввод. Ожидается id наименование количество частота.");
                            continue;
                        }
                        try {
                            int id = Integer.parseInt(data[0]);
                            String name = data[1];
                            int quantity = Integer.parseInt(data[2]);
                            double weight = Double.parseDouble(data[3].replace(",", "."));

                            sharedQueueInput.add(new Toy(id, name, quantity, weight));
                        } catch (NumberFormatException e) {
                            System.out.println("Некорректный ввод. Ожидается id наименование количество частота: " + e.getMessage());
                        }
                    }
                    for (Toy t : sharedQueueInput) {
                        fileWriter.write(String.format("%d %s %d %.2f%n", t.getId(), t.getName(), t.getQuantity(), t.getWeight()));
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                scanner.close();
                int[] inputId;
                ArrayList<String> inputNames = new ArrayList<>();
                double[] inputWeights;
                int[] inputQuantity;
                ArrayList<Integer> idList = new ArrayList<>();
                ArrayList<Double> weightList = new ArrayList<>();
                ArrayList<Integer> quantityList = new ArrayList<>();
                PriorityQueue<Toy> inputSharedQueue = new PriorityQueue<>();
                try (BufferedReader br = new BufferedReader(new FileReader("WeightOfToys.log"))){
                    String line;
                    while ((line = br.readLine()) != null) {
                        String[] parts = line.split(" ");
                        idList.add(Integer.parseInt(parts[0]));
                        inputNames.add(parts[1]);
                        quantityList.add(Integer.parseInt(parts[2]));
                        weightList.add(Double.parseDouble(parts[3].replace(",", ".")));
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
                inputWeights = weightList.stream().mapToDouble(Double::doubleValue).toArray();
                inputQuantity = quantityList.stream().mapToInt(Integer::intValue).toArray();

                for (int i = 0; i < inputId.length; i++) {
                    inputSharedQueue.add(new Toy(inputId[i], inputNames.get(i), inputQuantity[i], inputWeights[i]));
                }
                List<Toy> inputSortedToys = new ArrayList<>(inputSharedQueue);

                Collections.sort(inputSortedToys);
                try (BufferedWriter bw = Files.newBufferedWriter(Paths.get("WeightOfToys.log"), StandardCharsets.UTF_8, StandardOpenOption.CREATE,
                        StandardOpenOption.TRUNCATE_EXISTING)) {
                    for (Toy t : inputSortedToys) {
                        DecimalFormat df = new DecimalFormat("#.##");
//                        String formattedWeight = df.format(t.getWeight());
                        bw.write(String.format("%d %s %d %.4s%n", t.getId(), t.getName(), t.getQuantity(), t.getWeight()));
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
                int[] quantity = new Random().ints(size, 0, upperBound).toArray();
                double[] frequencies = new Random().doubles(size, 0, upperBound).toArray();
//                int[] ids = {1, 2, 3};
//                int[] frequencies = {2, 2, 6};
                ArrayList<String> names = readNamesFromFile("NameOfToys.txt");
                for (int i = 0; i < ids.length; i++) {
                    sharedQueue.add(new Toy(ids[i], names.get(new Random().nextInt(names.size())), quantity[i], frequencies[i]));
                }


                List<Toy> sortedToys = new ArrayList<>(sharedQueue);
                Collections.sort(sortedToys);
                try (BufferedWriter bw = Files.newBufferedWriter(Paths.get("WeightOfToys.log"), StandardCharsets.UTF_8, StandardOpenOption.CREATE,
                        StandardOpenOption.TRUNCATE_EXISTING)) {
                    for (Toy t : sortedToys) {
                        DecimalFormat df = new DecimalFormat("#.##");
//                        String formattedWeight = df.format(t.getWeight());
                        bw.write(String.format("%d %s %d %.4s%n", t.getId(), t.getName(), t.getQuantity(), t.getWeight()));
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
                            if (data.length != 4) {
                                System.out.println("Некорректный ввод. Ожидается id наименование количество частота.");
                                continue;
                            }
                            try {
                                int id = Integer.parseInt(data[0]);
                                String name = data[1];
                                int quantityAdd = Integer.parseInt(data[2]);
                                double weight = Double.parseDouble(data[3].replace(",", "."));

                                DecimalFormat df = new DecimalFormat("#.##");
//                        String formattedWeight = df.format(t.getWeight());

                                fileWriter.write(String.format("%d %s %d %.4s%n", id, name, quantityAdd, weight));
                            } catch (NumberFormatException e) {
                                System.out.println("Некорректный ввод. Ожидается id наименование количество частота: " + e.getMessage());
                            }
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    System.out.println("Файл пустой. Добавьте данные с использованием пункта 1.");
                }
                break;
            case 4:
                if (Files.size(Paths.get("WeightOfToys.log")) > 0) {
                    Scanner in = new Scanner(System.in);
                    System.out.println("Установите пороговый вес для отбора игрушек: ");
                    double weightThreshold = in.nextDouble();
                    System.out.println("Проводится розыгрыш:");
                    ArrayList<Integer> playId = new ArrayList<>();
                    ArrayList<String> playNames = new ArrayList<>();
                    ArrayList<Double> playWeights = new ArrayList<>();
                    ArrayList<Integer> quantityPlay = new ArrayList<>();
                    PriorityQueue<Toy> playSharedQueue = new PriorityQueue<>();
                    try (BufferedReader br = Files.newBufferedReader(Paths.get("WeightOfToys.log"), StandardCharsets.UTF_8)) {
                        String line;
                        while ((line = br.readLine()) != null) {
                            String[] parts = line.split(" ");
                            int id = Integer.parseInt(parts[0]);
                            String name = parts[1];
                            int quantityf = Integer.parseInt(parts[2]);
                            double weight = Double.parseDouble(parts[3].replace(",", "."));
                            playId.add(id);
                            playNames.add(name);
                            playWeights.add(weight);
                            quantityPlay.add(quantityf);
                            playSharedQueue.add(new Toy(id, name, quantityf, weight));
                        }
                    } catch (IOException e) {
                        System.out.println("Ошибка при чтении файла: " + e.getMessage());
                    }

                    List<Toy> selectedToys = new ArrayList<>();
                    for (int i = 0; i < playWeights.size(); i++) {
                        if (playWeights.get(i) < weightThreshold) {
                            selectedToys.add(new Toy(playId.get(i), playNames.get(i), quantityPlay.get(i), playWeights.get(i)));

                        }
                    }
//                    System.out.println(selectedToys);

                    Random random = new Random();
                    if (!selectedToys.isEmpty()) {
                        Toy selectedToy = selectedToys.get(random.nextInt(selectedToys.size()));

                        System.out.printf("Ваша игрушка: " + selectedToy);
                        int indexToRemove = selectedToys.indexOf(selectedToy);
                        int updatedQuantity = selectedToy.getQuantity() - 1;
                        if (updatedQuantity <= 0) {
                             selectedToys.remove(indexToRemove);

                            try (BufferedWriter bw = Files.newBufferedWriter(Paths.get("WeightOfToys.log"), StandardCharsets.UTF_8, StandardOpenOption.CREATE,
                                    StandardOpenOption.TRUNCATE_EXISTING)) {
                                for (Toy t : selectedToys) {
                                    DecimalFormat df = new DecimalFormat("#.##");
                                    bw.write(String.format("%d %s %d %.2f%n", t.getId(), t.getName(), t.getQuantity(), t.getWeight()));
                                }
                            } catch (IOException e) {
                                System.out.printf("Ошибка при перезаписи файла: %s%n", e.getMessage());
                            }
                        } else {
                            selectedToy.setQuantity(updatedQuantity);
                            System.out.printf("\nОбновленное количество игрушек %d: %d%n", selectedToy.getId(), updatedQuantity);
                        }
                    } else {
                        System.out.println("Нет подходящих игрушек для розыгрыша.");
                    }
                } else {
                    System.out.println("Файл пустой. Добавьте данные с использованием пункта 1.");
                }
                break;


        }
    }

    private void setQuantity(int updatedQuantity) {
    }
}
///*package Play_Toy;
//
//import java.io.BufferedReader;
//
//import java.io.BufferedWriter;
//
//import java.io.FileReader;
//
//import java.io.IOException;
//
//import java.nio.charset.StandardCharsets;
//
//import java.nio.file.Files;
//
//import java.nio.file.Path;
//
//import java.nio.file.Paths;
//
//import java.nio.file.StandardOpenOption;
//
//import java.util.ArrayList;
//
//import java.util.PriorityQueue;
//
//import java.util.Random;
//
//
//private class ToyDubl {
//
//    private static int id;
//
//    private String name;
//
//    private int weight;
//
//
//
//    public ToyDubl(int id, String name, int weight) {
//
//        this.id = id;
//
//        this.name = name;
//
//        this.weight = weight;
//
//    }
//
//    public int getId() {
//
//        return id;
//
//    }
//
//
//
//    public String getName() {
//
//        return name;
//
//    }
//
//    public int getWeight() {
//
//        return weight;
//
//    }
//
//
//
//
//
//    @Override
//
//    public String toString() {
//
//        return "id: " + id + "; Имя: " + name + "; Вес: " + weight;
//
//
//
//    }
//
//}
//
//
//
//
//
//public class ToySet {
//
//    public void main(String[] args) {
//
//      /*  //пример естественного добавления элементов в приоритетную очередь
//
//        Queue<Integer> integerPriorityQueue = new PriorityQueue<>(7);
//
//        Random rand = new Random();
//
//        for(int i=0; i<7; i++){
//
//            integerPriorityQueue.add(new Integer(rand.nextInt(100)));
//
//        }
//
//        for(int i=0;i<7;i++){
//
//            Integer in = integerPriorityQueue.poll();
//
//            System.out.println("Обрабатываем Integer:"+in);
//
//        }
//
//
//
//        //Пример PriorityQueue с компаратором
//
//        Queue<Toy> ToyPriorityQueue = new PriorityQueue<>(7, idComparator);
//
//        addDataToQueue(ToyPriorityQueue);
//
//
//
//        pollDataFromQueue(ToyPriorityQueue);
//
//
//
//    }
//
//
//
//    //Анонимный класс компаратора
//
//    public static Comparator<Toy> idComparator = new Comparator<Toy>(){
//
//
//
//        @Override
//
//        public int compare(Toy c1, Toy c2) {
//
//            return (int) (c1.getId() - c2.getId());
//
//        }
//
//    };
//
//
//
//    // служебный метод добавления элементов в очередь
//
//    private static void addDataToQueue(Queue<Toy> ToyPriorityQueue) {
//
//        Random rand = new Random();
//
//        for(int i=0; i<7; i++){
//
//            int id = rand.nextInt(100);
//
//            ToyPriorityQueue.add(new Toy(id, "Pankaj "+id));
//
//        }
//
//    }
//
//
//
//    //служебный метод для обработки данных очереди
//
//    private static void pollDataFromQueue(Queue<Toy> ToyPriorityQueue) {
//
//        while(true){
//
//            Toy cust = ToyPriorityQueue.poll();
//
//            if(cust == null) break;
//
//            System.out.println("Обработка клиента с id=" + cust.getId());
//
//        }
//
//    }
//
//*/
//
//
//
//
//
//    PriorityQueue<Toy> sharedQueue = new PriorityQueue<>();
//
//
//
//
//
//    sharedQueue.add(new Toy(1, "Teddy Bear", 100));
//
//    sharedQueue.add(new Toy(2, "LEGO", 200));
//
//    sharedQueue.add(new Toy(3, "Doll", 150));
//
//
//
//    /*Метод poll() возвращает объект типа Element, который представляет элемент очереди. Метод remove() выдает исключение, если очередь пуста, и в противном случае ничего не возвращает. Метод remove() может выдавать исключение InterruptedException, если оно прерывается во время ожидания блокировки монитора этой очереди или выполнения какой-либо другой операции блокировки (например, удаления из очереди или выталкивания элементов).*/
//
//
//
//    while (!sharedQueue.isEmpty()) {
//
//        Toy toy = sharedQueue.poll();
//
//        System.out.println("Toy id: " + toy.getId() + ", name: " + toy.getName() + ", weight: " + toy.getWeight());
//
//        }
//
//    }
//
//
//
//     class Toy implements Comparable<Toy> {
//
//         private int id;
//
//         private String name;
//
//         private int weight;
//
//
//
//         public Toy(int id, String name, int weight) {
//
//             this.id = id;
//
//             this.name = name;
//
//             this.weight = weight;
//
//         }
//
//
//
//         public int getId() {
//
//             return id;
//
//         }
//
//
//
//         public String getName() {
//
//             return name;
//
//         }
//
//
//
//         public int getWeight() {
//
//             return weight;
//
//         }
//
//
//
//         @Override
//
//         public int compareTo(Toy other) {
//
//             return Integer.compare(this.weight, other.weight);
//
//         }
//
//     }
//
//
//
//    PriorityQueue<Toy> generateSet(int n, int size) throws IOException {
//
//        PriorityQueue<Toy> toySet = new PriorityQueue<>();
//
//        int[] ids = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//
//        ArrayList<String> names = readNamesFromFile("toy_names.txt");
//
//        int[] frequencies = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//
//        Random rand = new Random();
//
//        for (int i = 0; i < size; i++) {
//
//            toySet.add(new Toy(ids[i], names.get(rand.nextInt(names.size())), frequencies[i]));
//
//        }
//
//        for (Toy t : toySet) {
//
//            t.weight += rand.nextInt(10);
//
//        }
//
//        Path logfile = Paths.get("toy_weight.log");
//
//        try (BufferedWriter writer = Files.newBufferedWriter(logfile, StandardCharsets.UTF_8, StandardOpenOption.WRITE)) {
//
//            for (Toy t : toySet) {
//
//                writer.write(String.format("Toy id: %d, name: %s, weight: %d%n", t.id, t.name, t.weight));
//
//            }
//
//        } catch (IOException e) {
//
//            e.printStackTrace();
//
//        }
//
//        return toySet;
//
//    }
//
//
//
//    static ArrayList<String> readNamesFromFile(String fileName) {
//
//        ArrayList<String> names = new ArrayList<>();
//
//        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
//
//            String line;
//
//            while ((line = reader.readLine()) != null) {
//
//                names.add(line.trim());
//
//            }
//
//            /*/String line = reader.readLine();
//
//            String[] nameArray = line.split(",");
//
//            for (String name : nameArray) {
//
//                names.add(name.trim());
//
//            }*/
//
//        } catch (IOException e) {
//
//            e.printStackTrace();
//
//        }
//
//        return names;
//
//    }
//
//}*/
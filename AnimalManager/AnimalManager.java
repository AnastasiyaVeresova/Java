import java.io.*;

import java.nio.file.Files;

import java.nio.file.Paths;

import java.time.LocalDate;

import java.time.format.DateTimeFormatter;

import java.time.format.DateTimeParseException;

import java.util.ArrayList;

import java.util.Arrays;

import java.util.Comparator;

import java.util.HashMap;

import java.util.HashSet;

import java.util.List;

import java.util.Map;

import java.util.Scanner;

import java.util.logging.Logger;

class Animal {

    private int id;

    private String name;

    private String type;

    private String birthDate;

    private List<String> commands;

    public Animal(int id, String type, String name, String birthDate, List<String> commands) {

        this.id = id;

        this.type = type;

        this.name = name;

        this.birthDate = birthDate;

        this.commands = commands;

    }

    public int getId() {

        return id;

    }

    public String getType() {

        return type;

    }

    public void addCommand(String command) {

        commands.add(command);

    }

    public String getName() {

        return name;

    }

    public String getBirthDate() {

        return birthDate;

    }

    public List<String> getCommands() {

        return commands;

    }

    @Override

    public String toString() {

        return "Питомец {" +

                "id: " + id + '\'' +

                ", тип: " + type + '\'' +

                ", имя: '" + name + '\'' +

                ", дата рождения: '" + birthDate + '\'' +

                ", команды: " + commands +

                '}';

    }

}

class AnimalType {

    private String typeName;

    private List<Animal> animals;

    public AnimalType(String typeName) {

        this.typeName = typeName;

        this.animals = new ArrayList<>();

    }

    public String getTypeName() {

        return typeName;

    }

    public List<Animal> getAnimals() {

        return animals;

    }

    public void addAnimal(Animal animal) {

        animals.add(animal);

    }

}
public class AnimalManager {

    static Logger logger = Logger.getAnonymousLogger();

    Scanner scanner = new Scanner(System.in, "UTF-8");

    private static final String fileName = "animals.txt";

    // private List<Animal> animals = new ArrayList<>();

   private static Map<String, AnimalType> animalTypes = new HashMap<>();

 

    public static void main(String[] args) {

        AnimalManager registry = new AnimalManager();

        registry.showMenu();

 

    }

 

    public void addAnimal() {
        String type;

        String name;

        String birthDate;

 

        while (true) {

 

            try {

                int lastId = readLastId();

                int newId = lastId + 1;

 

                System.out.print("Введите тип животного (или 'exit' для выхода): ");

                type = scanner.nextLine();

                if (type.equalsIgnoreCase("exit")) {

                    return;

                }

 

                while (type.isEmpty()) {

                    if (type.isEmpty()) {

                        System.out.println(

                                "Поле не может быть пустым. Пожалуйста, введите тип снова (или 'exit' для выхода): ");

                        type = scanner.nextLine();

                    }

                    if (type.equalsIgnoreCase("exit")) {

                        return;

                    }

                }

                AnimalType animalType = animalTypes.get(type);

                if (animalType == null) {

                    animalType = new AnimalType(type);

                    animalTypes.put(type, animalType);

                }

 

                System.out.print("Введите имя животного (или 'exit' для выхода): ");

                name = scanner.nextLine();

                if (name.equalsIgnoreCase("exit")) {

                    return;

                }

                while (name.isEmpty()) {

                    if (name.isEmpty()) {

                        System.out.println(

                                "Поле не может быть пустым. Пожалуйста, введите имя снова (или 'exit' для выхода): ");

                        name = scanner.nextLine();

                    }

                    if (name.equalsIgnoreCase("exit")) {

                        return;

                    }

                }

                System.out.print("Введите дату рождения в формате ГГГГ-ММ-ДД (или 'exit' для выхода): ");

                birthDate = scanner.nextLine();

                if (birthDate.equalsIgnoreCase("exit")) {

                    return;

                }

                while (!isValidBirthDate(birthDate)) {

                    System.out.println(

                            "Введите дату в формате ГГГГ-ММ-ДД и убедитесь, что она корректна (или 'exit' для выхода): ");

                    birthDate = scanner.nextLine();

                    if (birthDate.equalsIgnoreCase("exit")) {

                        return;

                    }

 

                }

                while (birthDate.isEmpty()) {

                    if (birthDate.isEmpty()) {

                        System.out.println(

                                "Поле не может быть пустым. Пожалуйста, введите дату рождения снова (или 'exit' для выхода): ");

                        birthDate = scanner.nextLine();

                    }

                    if (birthDate.equalsIgnoreCase("exit")) {

                        return;

                    }

                }

 

                System.out.print("Введите команды, которые умеет животное (через пробел): ");

                String commandsInput = scanner.nextLine();

                List<String> commands = Arrays.asList(commandsInput.split(" "));

                Animal animal = new Animal(newId, type, name, birthDate, commands);

                animalType.addAnimal(animal);

 

                writeAnimal(newId, type, name, birthDate, commands);

                System.out.println("Животное добавлено: " + animal);

            } catch (IOException e) {

                e.printStackTrace();

            }

        }

    }

 

    private static int readLastId() throws IOException {

        if (!Files.exists(Paths.get(fileName))) {

            return 0;

        }

 

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

            String lastLine = null;

            String currentLine;

 

            while ((currentLine = reader.readLine()) != null) {

                lastLine = currentLine;

            }

 

            if (lastLine != null) {

                String[] parts = lastLine.split(" ");

                return Integer.parseInt(parts[0]);

            }

        }

 

        return 0;

    }

 

    private static void writeAnimal(int id, String type, String name, String birthDate, List<String> commands)

            throws IOException {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {

            writer.write(id + " " + type + " " + name + " " + birthDate + " " + commands);

            writer.newLine();

        }

    }

 

    private static boolean isValidBirthDate(String birthDate) {

        String regex = "\\d{4}\\-\\d{2}\\-\\d{2}";

        if (!birthDate.matches(regex)) {

            return false;

        }

 

        try {

            LocalDate date = LocalDate.parse(birthDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            return true;

        } catch (DateTimeParseException e) {

            return false;

        }

    }

 
    public void listCommands() {

    }

 

    public void trainAnimal() {

    }

 
    public void listAnimalsByBirthDate() {

    }
    
    public void animalTypeList() {

    }

 

    public void animalsDelete() {

    }

 

    public void showMenu() {

        System.out.println("КНИГА ПИТОМЦЕВ\n_____________________\n");

        while (true) {

            System.out.println("1. Добавить новое животное");

            System.out.println("2. Список команд животного");

            System.out.println("3. Обучить животное новой команде");

            System.out.println("4. Вывести список животных от старшего к младшему");

            System.out.println("5. Вывести список животных по типу");

            System.out.println("6. Удалить животное из списка");

            System.out.println("7. Выход");

            System.out.print("Выберите опцию: ");

            int choice = scanner.nextInt();

            scanner.nextLine();

 

            switch (choice) {

                case 1:

                    addAnimal();

                    break;

                case 2:

                    listCommands();

                    break;

                case 3:

                    trainAnimal();

                    break;

                case 4:

                    listAnimalsByBirthDate();

                    break;

                case 5:

                    animalTypeList();

                    break;

                case 6:

                    animalsDelete();

                    break;

                case 7:

                    System.out.println("Выход из программы.");

                    return;

                default:

                    System.out.println("Неверный выбор. Пожалуйста, попробуйте снова.");

            }

        }

    }

}
 
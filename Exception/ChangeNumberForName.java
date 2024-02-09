package Exception;
/*
* Запишите в файл следующие строки:
Анна=4
Елена=5
Марина=6
Владимир=?
Константин=?
Иван=4
Реализуйте метод, который считывает данные из файла и сохраняет
* в двумерный массив (либо HashMap, если студенты с ним знакомы).
* В отдельном методе нужно будет пройти по структуре данных, если
* сохранено значение ?, заменить его на соответствующее число.
* Если на каком-то месте встречается символ, отличный от числа или ?,
* бросить подходящее исключение.Записать в тот же файл данные с замененными
* символами ?*/


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class ChangeNumberForName {
    static Map<String, String> map = new LinkedHashMap<>();

    public static void main(String[] args) {
        String filePathForRead = "src/Exception/test.txt";
        String filePathToWrite = "src/Exception/test1.txt";
        try {
            readFile(filePathForRead);
            writeToFile(filePathToWrite);
        } catch (FileNotFoundException e) {
            System.out.println("Не удалось считать файл");
        } catch (IOException e) {
            System.out.println("Не удалось записать в файл");
        }


    }
    static void writeToFile(String filePath) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                writer.write(entry.toString());
                writer.write("\n");
            }
        }
    }

    static void readFile(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                parseLine(line);

            }

        }
    }


    private static void parseLine(String line) {
        String[] arr = line.split("=");
        if (arr[1].equals("?")){
            arr[1] = String.valueOf(arr[0].length());
        }
        map.put(arr[0], arr[1]);
    }
}

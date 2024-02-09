package Itog_hw;
/*
Напишите приложение, которое будет запрашивать у пользователя следующие данные, разделенные пробелом:

Фамилия Имя Отчество дата _ рождения номер _ телефона пол

Форматы данных:

фамилия, имя, отчество - строки
дата _ рождения - строка формата dd.mm.yyyy
номер _ телефона - целое беззнаковое число без форматирования
пол - символ латиницей f или m.

Приложение должно проверить введенные данные по количеству. Если количество не совпадает, вернуть код ошибки, обработать его и показать пользователю сообщение, что он ввел меньше или больше данных, чем требуется.

Приложение должно распарсить полученную строку и выделить из них требуемые значения. Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы. Можно использовать встроенные типы java и создавать свои. Исключение должно быть корректно обработано, пользователю выведено сообщение с информацией, что именно неверно.

Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии, в него в одну строку должны записаться полученные данные, вида
<Фамилия> <Имя> <Отчество> <дата _ рождения> <номер _ телефона> <пол>

Однофамильцы должны записаться в один и тот же файл, в отдельные строки.
Не забудьте закрыть соединение с файлом.
При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано, пользователь должен увидеть стектрейс ошибки.*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Logger;

public class SurnameFile {
    static Logger logger = Logger.getAnonymousLogger();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные, разделенные пробелом:\n- Фамилия Имя Отчество\n- дата рождения(dd.mm.yyyy)\n- номер "
                + "телефона(цифры подряд без пробелов и знаков)\n- пол(символ латиницей f или m)");
        String userData = scanner.nextLine();
        scanner.close();

        int index = indexOfElement(userData);
        if (index == -1) {
            System.out.println("Вы ввели недостаточное количество данных");
        } else if (index == -2) {
            System.out.println("Вы ввели больше данных, чем требуется");
        } else {
            decoder(index, userData);
        }
    }

    public static int indexOfElement(String userData) {
        try {
            String[] data = userData.split(" ");
            if (data.length < 6) {
                return -1;
            }
            if (data.length > 6) {
                return -2;
            }
            String lastName = data[0];
            String firstName = data[1];
            String middleName = data[2];
            String birthDate = data[3];
            long phoneNumber = Long.parseLong(data[4]);
            char gender = data[5].charAt(0);
            if (!isValidBirthDate(birthDate)) {
                throw new IllegalArgumentException("Неверный формат даты рождения");
            }
            if (!isValidGender(gender)) {
                throw new IllegalArgumentException("Неверно обозначен пол: ожидается символ латиницей f (female) или m (male)");
            }
            String fileName = lastName + ".txt";
            String fileContent = String.format("%s %s %s %s %d %c", lastName, firstName, middleName, birthDate, phoneNumber, gender);
            File file = new File(fileName);
            if (file.exists()) {
                if (fileContentContains(file, userData)) {
                    System.out.println("Введенная строка уже присутствует в файле " + fileName);
                } else {
                    appendToFile(file, fileContent);
                    logger.info("Данные успешно записаны в файл " + fileName);
                }
            } else {
                writeToFile(file, fileContent);
                logger.info("Данные успешно записаны в файл " + fileName);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.warning("Запись в файл не удалась. " + e.getMessage());
        }
        return 0;
    }

    public static void decoder(int code, String userData) {
        switch (code) {
            case -1:
                System.out.println("Вы ввели недостаточное количество данных");
                break;
            case -2:
                System.out.println("Вы ввели больше данных, чем требуется");
                break;
        }
    }

    private static boolean isValidBirthDate(String birthDate) {
        String regex = "\\d{2}\\.\\d{2}\\.\\d{4}";
        return birthDate.matches(regex);
    }

    private static boolean isValidGender(char gender) {
        return gender == 'f' || gender == 'm';
    }

    static void writeToFile(File file, String fileContent) throws IOException {
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(fileContent + "\n");
        fileWriter.close();
    }

    static void appendToFile(File file, String fileContent) throws IOException {
        FileWriter fileWriter = new FileWriter(file, true);
        fileWriter.write(fileContent + "\n");
        fileWriter.close();
    }

    static boolean fileContentContains(File file, String userData) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                if (line.equals(userData)) {
                    return true;
                }
            }
        }
        return false;
    }
}
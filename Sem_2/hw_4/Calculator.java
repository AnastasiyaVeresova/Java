package Sem_2.hw_4;
    /* * @apiNote Напишите класс Calculator, который будет выполнять математические операции (+, -, *, /)
    над двумя числами и возвращать результат. В классе должен быть метод calculate,
    который принимает оператор и значения аргументов и возвращает результат вычислений.
     При неверно переданном операторе, программа должна вывести сообщение об ошибке
     "Некорректный оператор: 'оператор'". * @param op математическиий оператор
     * @param a первый параметр * @param b второй параметр * @return результат вычисления */

/*
 * @apiNote Делает запись текущего состояния массива в лог файл
 * @param mas массив
 */

/*
// class Calculator { public int calculate(char op, int a, int b)
//     { try (FileWriter fileWriter = new FileWriter(new File("log.txt"), true))
//     { logStep(fileWriter, "User entered the first operand = " + a);
//         logStep(fileWriter, "User entered the operation = " + op);
//         logStep(fileWriter, "User entered the second operand = " + b);

//     switch (op) {
//         case '+':
//             int sum = add(a, b);
//             logStep(fileWriter, "Result is " + sum);
//             return sum;
//         case '-':
//             int diff = minus(a, b);
//             logStep(fileWriter, "Result is " + diff);
//             return diff;
//         case '*':
//             int prod = mult(a, b);
//             logStep(fileWriter, "Result is " + prod);
//             return prod;
//         case '/':
//             int quotient = divide(a, b);
//             logStep(fileWriter, "Result is " + quotient);
//             return quotient;
//         default:
//             throw new IllegalArgumentException("Некорректный оператор: " + op);
//     }
// } catch (IOException e) {
//     e.printStackTrace();
//     return -1;
// }
// }

//     private int divide(int a, int b) {
//         if (b != 0) return a / b;
//         throw new ArithmeticException("Деление на 0 недопустимо");
//     }

//     private int mult(int a, int b) {
//         return a * b;
//     }

//     private int minus(int a, int b) {
//         return a - b;
//     }

//     private int add(int a, int b) {
//         return a + b;
//     }

//     private void logStep(FileWriter fileWriter, String note) throws IOException {
//         LocalDateTime currentTime = LocalDateTime.now();
//         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
//         String formattedTime = currentTime.format(formatter);
//         fileWriter.write(formattedTime + " " + note + "\n");
//     }

// }

// class Printer {

//     private static final String LOG_FILE_PATH = "log.txt";

//     public static void main(String[] args) {
//         int a = 0;
//         char op = ' ';
//         int b = 0;

//         if (args.length == 0) {
//             a = 3;
//             op = '+';
//             b = 7;
//         } else {
//             a = Integer.parseInt(args[0]);
//             op = args[1].charAt(0);
//             b = Integer.parseInt(args[2]);
//         }

//         clearLogFile();
//         Calculator calculator = new Calculator();
//         int result = calculator.calculate(op, a, b);
//         System.out.println(result);

//         try (BufferedReader br = new BufferedReader(new FileReader(LOG_FILE_PATH))) {
//             String line;
//             while ((line = br.readLine()) != null) {
//                 System.out.println(line);
//             }
//         } catch (IOException e) {
//             e.printStackTrace();
//         }
//     }

//     private static void clearLogFile() {
//         File logFile = new File(LOG_FILE_PATH);
//         if (logFile.exists()) {
//             try {
//                 FileWriter fileWriter = new FileWriter(logFile, false);
//                 fileWriter.write("");
//                 fileWriter.close();
//             } catch (IOException e) {
//                 e.printStackTrace();
//             }
//         }
//     }
// }
*/


// К этому калькулятору нужно добавить логирование.

// Логи запишите в файл log.txt в формате:

// "гггг-мм-дд чч:мм User entered the first operand = {первое число}" // "гггг-мм-дд чч:мм User entered the operation = {оператор}" // "гггг-мм-дд чч:мм User entered the second operand = {второе число}" // "гггг-мм-дд чч:мм Result is {результат}"

// import java.io.File;
// import java.io.FileWriter;
// import java.io.FileReader;
// import java.io.IOException;
// import java.sql.Timestamp;
// import java.io.BufferedReader;
// import java.time.LocalDateTime;
// import java.time.format.DateTimeFormatter;

// class Calculator {

//     private static void writeToLog(String message) {
//         Timestamp date = new Timestamp(System.currentTimeMillis());
//         LocalDateTime localDateTime = date.toLocalDateTime();
//         DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
//         try {
//             FileWriter fileWriter = new FileWriter("log.txt", true);

//             fileWriter.append(dateTimeFormatter.format(localDateTime) + " " + message + "\n");
//             fileWriter.flush();
//         }
//         catch (Exception ex) {
//             System.out.println(ex.getMessage());
//         }
//     }


//     public int calculate(char op, int a, int b) {
//         // Введите свое решение ниже

//         int result = 0;
//         if (op == '+')
//             result = a + b;
//         else if (op == '-')
//             result =  a - b;
//         else if (op == '*')
//             result =  a * b;
//         else if (op == '/')
//             result =  a / b;

//         writeToLog("User entered the first operand = " + a);
//         writeToLog("User entered the operation = " + op);
//         writeToLog("User entered the second operand = " + b);
//         writeToLog("Result is " + result);
//         return result;
//     }
// }

// class Printer { private static final String LOG_FILE_PATH = "log.txt";

//     public static void main(String[] args) {
//         int a = 0;
//         char op = ' ';
//         int b = 0;

//         if (args.length == 0) {
//             // При отправке кода на Выполнение, вы можете варьировать эти параметры
//             a = 3;
//             op = '+';
//             b = 7;
//         } else {
//             a = Integer.parseInt(args[0]);
//             op = args[1].charAt(0);
//             b = Integer.parseInt(args[2]);
//         }

//         clearLogFile();
//         Calculator calculator = new Calculator();
//         int result = calculator.calculate(op, a, b);
//         System.out.println(result);

//         try (BufferedReader br = new BufferedReader(new FileReader(LOG_FILE_PATH))) {
//             String line;
//             while ((line = br.readLine()) != null) {
//                 System.out.println(line);
//             }
//         } catch (IOException e) {
//             e.printStackTrace();
//         }
//     }

//     private static void clearLogFile() {
//         File logFile = new File(LOG_FILE_PATH);
//         if (logFile.exists()) {
//             try {
//                 FileWriter fileWriter = new FileWriter(logFile, false);
//                 fileWriter.write("");
//                 fileWriter.close();
//             } catch (IOException e) {
//                 e.printStackTrace();
//             }
//         }
//     }
// }

/*
import org.json.JSONArray;
import org.json.JSONObject;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Calculator {

    public static void main(String[] args) {
        try {
            String jsonString = new String(Files.readAllBytes(Paths.get("data.json")));
            JSONArray jsonArray = new JSONArray(jsonString);

            StringBuilder stringBuilder = new StringBuilder();

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String фамилия = jsonObject.getString("фамилия");
                String оценка = jsonObject.getString("оценка");
                String предмет = jsonObject.getString("предмет");

                stringBuilder.append("Студент ")
                        .append(фамилия)
                        .append(" получил ")
                        .append(оценка)
                        .append(" по предмету ")
                        .append(предмет)
                        .append(".\n");
            }

            System.out.println(stringBuilder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

 */
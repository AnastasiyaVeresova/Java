package Sem_1.hw_3;
//Реализовать простой калькулятор

import java.util.Scanner;

//public class Calculator {
//    public static void main (String[] args) {
//        double operand1;
//        double operand2;
//        double result;
//        char operator;
//        Scanner reader = new Scanner (System.in);
//        System.out.print("Введите два числа: ");
//        operand1 = reader.nextDouble();
//        operand2 = reader.nextDouble();
//        System.out.print("Введите оператор (+, -, *, /): ");
//        operator = reader.next().charAt(0);
//        switch (operator) {
//            case '+':
//                result = operand1 + operand2;
//                break;
//            case '-':
//                result = operand1 - operand2;
//                break;
//            case '*':
//                result = operand1 * operand2;
//                break;
//            case '/':
//                result = operand1 / operand2;
//                break;
//            default:
//                System.out.println("Некорректный оператор: '" + operator + "'");
//                return;
//        }
////        return result;
//        System.out.print("Результат: ");
//        System.out.printf(operand1 + " " + operator + " " + operand2 + " = " + result);
//    }
//}

class Calculator {
    int result;
    public int calculate(char op, int a, int b) {
        switch (op) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                if (b != 0) {
                    result = a / b;
                }
                else {
                        System.out.println("На 0 делить нельзя!");
                    }
                break;

        }
        return result;


    }
}

// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
class Printer{
    public static void main(String[] args) {
        int a = 0;
        char op = ' ';
        int b = 0;


        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            a = 5;
            op = '/';
            b = 5;
        } else {
            a = Integer.parseInt(args[0]);
            op = args[1].charAt(0);
            b = Integer.parseInt(args[2]);
        }

        Calculator calculator = new Calculator();
        int result = calculator.calculate(op, a, b);
        System.out.println(result);
    }
}
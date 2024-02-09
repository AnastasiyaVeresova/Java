package Sem_4.hw_3;
/*
В обычный калькулятор без логирования добавьте возможность отменить последнюю операцию.
Отмена последней операции должна быть реализована следующим образом: если передан оператор
'<' калькулятор должен вывести результат предпоследней операции.

calculate('+', 3, 7)
calculate('+', 4, 7)
calculate('<', 0, 0)

// 10.0
// 11.0
// 10.0

calculate('*', 3, 2)
calculate('-', 7, 4)
calculate('<', 0, 0)

// 6.0
// 3.0
// 6.0




import java.util.ArrayDeque;
import java.util.Deque;

class Calculator {
    public int calculate(char op, int a, int b) {
        // Напишите свое решение ниже


    }
}


// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
public class Printer {
    public static void main(String[] args) {
        int a, b, c, d;
        char op, op2, undo;

        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            a = 3;
            op = '+';
            b = 7;
            c = 4;
            op2 = '+';
            d = 7;
            undo = '<';
        } else {
            a = Integer.parseInt(args[0]);
            op = args[1].charAt(0);
            b = Integer.parseInt(args[2]);
            c = Integer.parseInt(args[3]);
            op2 = args[4].charAt(0);
            d = Integer.parseInt(args[5]);
            undo = args[6].charAt(0);
        }

        Calculator calculator = new Calculator();
        int result = calculator.calculate(op, a, b);
        System.out.println(result);
        int result2 = calculator.calculate(op2, c, d);
        System.out.println(result2);
        int prevResult = calculator.calculate(undo, 0, 0);
        System.out.println(prevResult);
    }
}
//===============================
*/

import java.util.ArrayDeque;
import java.util.Deque;

class Calculator {
   Deque<Double> stack = new ArrayDeque<>();
    public Double calculate(char op, double a, double b) {
        double result = 0;
        switch (op) {
            case '+':
                result = a + b;
                stack.push(result);
                break;
            case '-':
                result = a - b;
                stack.push(result);
                break;
            case '*':
                result = a * b;
                stack.push(result);
                break;
            case '/':
                if (b == 0) {
                    System.out.println("На ноль делить нельзя!");
                } else {
                    result = a / b;
                    stack.push(result);
                    break;
                }

            case '<':
                if (!stack.isEmpty()) {
                    stack.pop();
                    if (!stack.isEmpty()) {
                        result = stack.peek();
                    } else {
                        result = 0;
                    }
                }
                break;
             default:
                System.out.println("Недопустимый оператор: " + op);
        }
        return result;

    }
    public void undo() {
        if (stack.size() < 2) {
            System.out.println("Нет предыдущей операции для отмены");
            return;
        }
        stack.pop();
        double previousResult = stack.peek();
        System.out.println(previousResult);
    }
}


// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
class Printer {
    public static void main(String[] args) {
        double a, b, c, d;
        char op, op2, undo;

        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            a = 3;
            op = '+';
            b = 7;
            c = 4;
            op2 = '+';
            d = 7;
            undo = '<';
        } else {
            a = Integer.parseInt(args[0]);
            op = args[1].charAt(0);
            b = Integer.parseInt(args[2]);
            c = Integer.parseInt(args[3]);
            op2 = args[4].charAt(0);
            d = Integer.parseInt(args[5]);
            undo = args[6].charAt(0);
        }

        Calculator calculator = new Calculator();
        double result = calculator.calculate(op, a, b);
        System.out.println(result);
        double result2 = calculator.calculate(op2, c, d);
        System.out.println(result2);
        double prevResult = calculator.calculate(undo, 0, 0);
        System.out.println(prevResult);
    }
}


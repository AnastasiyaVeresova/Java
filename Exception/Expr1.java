package Exception;

/*
* Напишите программу для выполнения арифметической операции деления двух целых чисел a и b.
При этом программа должна проверить, что делитель b не равен нулю, и выполнить деление только в этом случае.
Если b равен нулю, программа должна вывести сообщение о невозможности выполнения операции и вернуть результат равный нулю.
После выполнения операции деления, программа также должна вывести сумму чисел a и b с помощью метода printSum.
Если аргументы не переданы через командную строку, используйте значения по умолчанию.

На входе:


'12'
'5'
На выходе:


17
2.4*/

public class Expr1 {
    public static double expr(int a, int b) {
        printSum(a, b);

        if (b != 0) {
            double result = (double) a / b;
            return result;
        } else {
//            System.out.println("Невозможно выполнить операцию");
            return 0;
        }
    }


    public static void printSum(int a, int b) {
        int sum = a + b;
        System.out.println(sum);
    }
}

// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки


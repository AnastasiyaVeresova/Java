

package Sem_1.hw_1;
//Вычислить n-ое треугольного число(сумма чисел от 1 до n), n! (произведение чисел от 1 до n)
import java.util.Scanner;

//
////проверка - является ли число треугольным
//public class Answer {
//    public static boolean isTriangular(int num) {
//        if (num < 0)
//            return false;
//        int sum = 0;
//        for (int n = 1; sum <= num; n++) {
//            sum = sum + n;
//            if (sum == num)
//                return true;
//        }
//        return false;
//    }
//    public static void main (String[] args) {
//        Scanner in = new Scanner(System.in);
//        System.out.println("Введите число: ");
//        int n = in.nextInt();
////        int n = 55;
//        if (isTriangular(n))
//            System.out.print((n * (n + 1)) / 2);
////            return (n * (n + 1)) / 2;
//
//        else
//            System.out.print("Число" + " Не треугольное");
//    }
//}


//public class Answer {
//    public static void main (String[] args) {
//        Scanner iScanner = new Scanner(System.in);
//        System.out.println("Введите число: ");
//        int i = iScanner.nextInt();
//        System.out.printf("Треугольное число: %d\n", giveMeNumber(i));
//        iScanner.close();
//    }
//    public static  int giveMeNumber(int n) {
//        return (n * (n + 1)) / 2;
//    }
//}



class Answer {
    public int countNTriangle(int n){
        return (n * (n + 1)) / 2;

    }
}

// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
class Printer{
    public static void main(String[] args) {
        int n = 0;

        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            n = 4;
        }
        else{
            n = Integer.parseInt(args[0]);
        }

        // Вывод результата на экран
        Answer ans = new Answer();
        int itresume_res = ans.countNTriangle(n);
        System.out.println(itresume_res);
    }
}
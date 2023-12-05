package Sem_1.hw_2;

//Вывести все простые числа от 1 до 1000
//
//public class Answer {
//    public static void main(String[] args) {
//        printPrimeNum();
//    }
//        public static void printPrimeNum() {
//            for (int i = 2; i <= 1000; i++) {
//                if (isPrime(i)) {
//                    System.out.println(i);
//                }
//            }
//        }
//        public static boolean isPrime(int num) {
//            if (num <= 1) {
//                return false;
//            }
//            for (int i = 2; i <= Math.sqrt(num); i++) {
//                if (num % i == 0) {
//                return false;
//            }
//        }
//        return true;
//    }
//}

class Answer {
    public void printPrimeNums(){
        for (int i = 2; i <= 1000; i++) {
            if (isPrime(i)) {
                System.out.println(i);
            }
        }
    }
    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}

// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
class Printer{
    public static void main(String[] args) {

        Answer ans = new Answer();
        ans.printPrimeNums();
    }
}


package Sem_3.hw_3;

/*
Инструкция по использованию платформы

Реализуйте метод, который принимает на вход целочисленный массив arr:
- Создаёт список ArrayList, заполненный числами из исходого массива arr.
- Сортирует список по возрастанию и выводит на экран.
- Находит минимальное значение в списке и выводит на экран - Minimum is {число} -
Находит максимальное значение в списке и выводит на экран - Maximum is {число}
- Находит среднее арифметическое значений списка и выводит на экран - Average is =  {число}
Напишите свой код в методе analyzeNumbers класса Answer. Метод analyzeNumbers принимает на вход один параметр:
Integer[] arr - массив целых чисел.
Пример.
Исходный массив:
4, 2, 7, 5, 1, 3, 8, 6, 9
Результаты:
[1, 2, 3, 4, 5, 6, 7, 8, 9]
Minimum is 1
Maximum is 9
 */

import java.util.*;
import java.util.List;


class Answer {
    public static void analyzeNumbers(Integer[] arr) {
        List<Integer> result = new ArrayList<>();
        for(Integer num : arr) {
            result.add(num);
        }
//        System.out.println(result);
        result.sort(Comparator.naturalOrder());
        System.out.println(result);

        int min = Collections.min(result);
        System.out.println("Minimum is " + min);
        int max = Collections.max(result);
        System.out.println("Maximum is " + max);
        int sum = 0;
        for (Integer num : arr) {
            sum += num;
        }
        double average = (double) sum / result.size();
        System.out.println("Average is " + average);
    }
}


// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
class Printer{
    public static void main(String[] args) {
        Integer[] arr = {};

        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            arr = new Integer[]{4, 2, 7, 5, 1, 3, 8, 6, 9};
        }
        else{
            arr = Arrays.stream(args[0].split(", "))
                    .map(Integer::parseInt)
                    .toArray(Integer[]::new);
        }

        Answer ans = new Answer();
        ans.analyzeNumbers(arr);
    }
}

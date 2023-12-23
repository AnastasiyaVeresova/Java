package Sem_3.hw_2;

/*
Удаление четных элементов
Дан произвольный массив целых чисел. Создайте список ArrayList, заполненный данными из этого массива.
Необходимо удалить из списка четные числа и вернуть результирующий.
Напишите свой код в методе removeEvenNumbers класса Answer.
Метод removeEvenNumbers принимает на вход один параметр: Integer[] arr - список целых чисел,
возвращает список ArrayList<Integer>
Примеры.
Исходный массив:

1, 2, 3, 4, 5, 6, 7, 8, 9
Результат:

[1, 3, 5, 7, 9]
Исходный массив:

2, 4, 6, 8
Результат:

[]
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Answer {
    public static void removeEvenNumbers(Integer[] arr) {
        List<Integer> result = new ArrayList<>();
//        for (Integer num : arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                result.add(arr[i]);
            }
        }
        System.out.println(result);
    }
}

// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
class Printer{
    public static void main(String[] args) {
        Integer[] arr = {};

        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            arr = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        }
        else{
            arr = Arrays.stream(args[0].split(", "))
                    .map(Integer::parseInt)
                    .toArray(Integer[]::new);
        }

        Answer ans = new Answer();
        ans.removeEvenNumbers(arr);
    }
}
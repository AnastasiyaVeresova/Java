package Sem_3.hw_1;

/*

Сортировка слиянием
Инструкция по использованию платформы

Внутри класса MergeSort напишите метод mergeSort, который принимает массив целых чисел,
реализует алгоритм сортировки слиянием. Метод должен возвращать отсортированный массив.

Пример

a = {5, 1, 6, 2, 3, 4} -> [1, 2, 3, 4, 5, 6]
 */

import java.util.Arrays;

class MergeSort {
    public static int[] mergeSort(int[] a) {
        if (a.length <= 1) {
            return a;
        }
        int mid = a.length/2;
        int[] left = new int[mid];
        int[] right = new int[a.length - mid];

        System.arraycopy(a, 0, left, 0, left.length);
        System.arraycopy(a, mid, right, 0, right.length);
        mergeSort(left);
        mergeSort(right);
        merge(left, right, a);
        return a;
    }
    private static void merge(int[] left, int[] right, int[] result) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                result[k++] = left[i++];
            }
            else {
                result[k++] = right[j++];
            }
        }
        while (i < left.length) {
            result[k++] = left[i++];
        }
        while (j < right.length) {
            result[k++] = right[j++];
        }
    }
}

// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
class Printer{
    public static void main(String[] args) {
        int[] a;

        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            a = new int[]{5, 1, 6, 2, 3, 4};
        } else {
            a = Arrays.stream(args[0].split(", ")).mapToInt(Integer::parseInt).toArray();
        }

        MergeSort answer = new MergeSort();
        String itresume_res = Arrays.toString(answer.mergeSort(a));
        System.out.println(itresume_res);
    }
}
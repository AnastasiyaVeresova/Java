package Sem_3;

/*
Заполнить список десятью случайными числами.
Отсортировать список методом sort() и вывести его на экран.
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Main1 {
    public static void main(String[] args) {
        int n = 10;
        Random random = new Random();
        List<Integer> lst = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            lst.add(random.nextInt(0, 10));
        }
        System.out.println(lst);
        lst.sort(Comparator.reverseOrder());
        System.out.println(lst);
    }
}

package Sem_3;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        int a = 5;
        String s = "привет";

        test(list, a, s);

        System.out.println(list);
        System.out.println(a);
        System.out.println(s);
    }

    static void test(List<Integer> list, int a, String s){
        a++;
        list.add(a);
        s = "пока";
    }
}

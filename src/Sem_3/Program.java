package Sem_3;
/*
Создать список типа ArrayList
Поместить в него как строки, так и целые числа.
Пройти по списку, найти и удалить целые числа.


 */
/*
import java.util.*;

public class Program {
    public static void main(String[] args) {

        ArrayList list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add("kujgb");
        list.add('c');
        list.add(null);
        list.add(3.1444);
        System.out.println(list);
//        for (int i = 0; i < list.size(); i++) {
//            if (list.get(i) instanceof Integer) {
//                list.remove(i);
//                i--;
//            }
//        }

        Iterator<Object> iterator = list.iterator();
//        while (iterator.hasNext()) {
//            if (iterator.next() instanceof Integer) {
//                iterator.remove();
//            }
//        }

        list.removeIf(x -> x instanceof Integer);

        System.out.println(list);
    }
}

/*
Каталог товаров книжного магазина сохранен в виде двумерного списка List<ArrayList<String>> так, что на 0й позиции каждого внутреннего списка содержится название жанра, а на остальных позициях - названия книг. Напишите метод для заполнения данной структуры.
 */
/*
import java.util.List;
import java.util.Random;
public class Program {
    public static void main(String[] args) {
        List<List<String>> catalog = new ArrayList<>();
        addBook(catalog, "adventure", "LOTR");
        addBook(catalog, "roman", "Мастер и Маргарита");
        addBook(catalog, "politic", "Государь");
        addBook(catalog, "adventure", "Hobbit");
        System.out.println(catalog);
    }

    static void addBook(List<List<String>> catalog, String genre, String name) {
        for (int i = 0; i < catalog.size(); i++) {
            List<String> innerCatalog = catalog.get(i);
            if (innerCatalog.get(0).equals(genre)) {
                innerCatalog.add(name);
                return;
            }
        }
        List<String> newInnerCatalog = new ArrayList<>();
        newInnerCatalog.add(genre);
        newInnerCatalog.add(name);
        catalog.add(newInnerCatalog);
    }
}



*/

/*

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 */

/*
Заполнить список названиями планет Солнечной системы в произвольном порядке с повторениями.
Вывести название каждой планеты и количество его повторений в списке.
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Program {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        String[] planets= {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune", "Pluto"};
        int n = 10;
        Random rand = new Random();
        for(int i = 0; i < n; i++)
        {
            list.add(planets[rand.nextInt(0,planets.length)]);
        }

        for (String i: planets){
            int c = Collections.frequency(list, i);
            System.out.println(i+": "+c);
        }
        System.out.println(list);
    }


}
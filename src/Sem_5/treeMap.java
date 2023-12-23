package Sem_5;


/*
Взять набор строк, например,

Мороз и солнце день чудесный
Еще ты дремлешь друг прелестный
Пора красавица проснись.

Написать метод, который отсортирует эти слова по длине с помощью TreeMap.
Слова с одинаковой длиной не должны “потеряться”.
 */

import java.util.*;

class treeMap {
    public static void main(String[] args) {
        Map<Integer, List<String>> map = new TreeMap<>(Comparator.reverseOrder());
        String s = "Мороз и солнце день чудесный\n" +
                "Еще ты дремлешь друг прелестный\n" +
                "Пора красавица проснись.";
        s = s.replace("\n", " ");
        s = s.replace(".", "");
        String[] words = s.split(" ");
        for (String word: words){
            int len = word.length();
//            if (map.containsKey(len)){
//                List<String> list = map.get(len);
//                list.add(word);
//            } else {
//                List<String> list = new LinkedList<>();
//                list.add(word);
//                map.put(len, list);
//            }
            List<String> list = map.getOrDefault(len, new LinkedList<>());
            list.add(word);
            if (!map.containsKey(len)){
                map.put(len, list);
            }
        }
        System.out.println(map);
    }
}

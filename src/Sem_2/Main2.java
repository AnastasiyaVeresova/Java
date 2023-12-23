package Sem_2;

/*
Напишите метод, который сжимает строку.
Пример: вход aaaabbbcdd.
Результат: a4b3cd2
 */

public class Main2 {
    public static void main(String[] args) {
        String s = "aaaabbbcdd";
        System.out.println(zipStr(s));
    }
    public static String zipStr(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        int count = 1;
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                count++;
            } else {
                stringBuilder.append(str.charAt(i));
                if (count != 1) {
                    stringBuilder.append(count);
                }
                count = 1;
            }
        }
        stringBuilder.append(str.charAt(str.length() - 1));
        if (count != 1) {
            stringBuilder.append(count);
        }
        return stringBuilder.toString();
    }
}

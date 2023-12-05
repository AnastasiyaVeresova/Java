package Sem_2;
/*
Напишите метод, который принимает на вход строку (String) и определяет является ли строка палиндромом (возвращает boolean значение).
Полиндром - Слово или фраза, которые одинаково читаются слева направо и справа налево.
 */
public class Palindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("А роза упала на лапу Азора"));
    }

    public static boolean isPalindrome(String s) {
        s = s.replace(" ", "");
        StringBuilder sb = new StringBuilder(s);
        String reversed = sb.reverse().toString();
        return s.equalsIgnoreCase(reversed);
    }
}

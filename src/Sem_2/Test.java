package Sem_2;

// ***Напишите метод, который сжимает строку.
// *Пример: вход aaaabbbcdd.
// *Результат: a4b3cd2
public class Test {
    public static void main(String[] args) {
        System.out.println(task02("aaaabbccd"));
    }


    public static String task02(String s)
    {
        StringBuilder result = new StringBuilder();
        char ch;
        int count = 0;
        ch = s.charAt(0);
        char[] arr = s.toCharArray();
        for(char temp : arr)
        {
            if (temp != ch){
                result.append(ch);
                result.append(count);
                ch = temp;
                count = 1;
            }
            else{
                count++;
            }
        }
        result.append(ch);
        result.append(count);

        return result.toString();
    }
}

package Sem_2;

public class Main3 {
    public static void main(String[] args) {
        System.out.println(polindromV2("А роза упала на лапу Азора"));
    }

    public static boolean polindrom(String str) {
        str = str.toLowerCase();
        str = str.replace(" ", "");
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static boolean polindromV2(String str){
        str = str.toLowerCase();
        str = str.replace(" ", "");
        StringBuilder stringBuilder = new StringBuilder(str);
        stringBuilder.reverse();
        return stringBuilder.toString().equals(str);
    }
}

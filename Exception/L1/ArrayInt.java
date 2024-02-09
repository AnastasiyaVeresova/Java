package Exception.L1;

/*
Реализуйте метод, принимающий в качестве аргумента целочисленный массив.
Если длина массива меньше некоторого заданного минимума, метод возвращает -1,
в качестве кода ошибки, иначе - длину массива.
 */

public class ArrayInt {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        System.out.println(getLength(arr));
    }

    static int getLength(int[] arr){
        int minLen = 5;
        if (arr.length < minLen){
            return -1;
        }
        return arr.length;
    }
}

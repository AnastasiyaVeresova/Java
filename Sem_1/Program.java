package Sem_1;

//Дан массив двоичных чисел, например [1,1,0,1,1,1], вывести максимальное количество подряд идущих 1.

public class Program {
    public static void main(String[] args) {
        int[] arr = {1,1,0,1,1,1};
        int max = 0;
        int tempMax = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                tempMax++;
            } else {
                if (max < tempMax) {
                    max = tempMax;
                }
                tempMax = 0;
            }
        }
        if (max < tempMax) {
            max = tempMax;
        }
        System.out.println(max);
    }
}

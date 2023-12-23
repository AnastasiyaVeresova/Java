package Sem_1;

import java.util.Arrays;

/*
Дан массив nums = [3,2,5,3] и число val = 3.
Если в массиве есть числа, равные заданному, нужно перенести эти элементы в конец массива.
Таким образом, первые несколько (или все) элементов массива должны быть отличны от заданного, а остальные - равны ему.
 */
class Main3 {
    public static void main(String[] args) {
        int[] nums = {3, 2, 5, 3};
        int val = 3;
        int[] res = sort_array(nums, val);
        System.out.println(Arrays.toString(res));
    }
    static int[] sort_array(int[] arr, int num){
        int tmp = 0;
        int [] res_arr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                res_arr[arr.length-tmp-1] = num;
                tmp++;
            } else {
                res_arr[i-tmp] = arr[i];
            }
        }
        return res_arr;
    }
}

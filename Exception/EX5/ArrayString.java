package Exception.EX5;
/*
* Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4.
* При подаче массива другого размера необходимо бросить исключение
* MyArraySizeException.
Далее метод должен пройтись по всем элементам массива, преобразовать в int и
* просуммировать. Если в каком-то элементе массива преобразование не удалось
* (например, в ячейке лежит символ или текст вместо числа), должно быть
* брошено исключение MyArrayDataException с детализацией, в какой именно
* ячейке лежат неверные данные.
В методе main() вызвать полученный метод, обработать возможные исключения
* MyArraySizeException и MyArrayDataException и вывести результат расчета
* (сумму элементов, при условии что подали на вход корректный массив).*/
public class ArrayString {

    public static void main(String[] args) {
        String[][] arr = new String[][]{
                {"1", "2", "3", "4"},
                {"1" , "2", "s", "5"},
                {"1", "2", "15", "4"},
                {"1", "2", "17", "4"}
        };
        while (true){
            try {
                int s = sumArr(arr);
                System.out.println(s);
                break;
            } catch (MyArrayDataException e){
                arr[e.getX()][e.getY()] = "80";

            }
        }



    }
    public static int sumArr(String[][] arr){
        int sum = 0;
        if (arr.length != 4) {
            throw new MyArraySizeException(arr.length, arr[0].length);
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 4) {
                throw new MyArraySizeException(arr.length, arr[i].length);
            }
            for (int j = 0; j < arr[i].length; j++) {
                if (!arr[i][j].matches("\\d*")){
                    throw new MyArrayDataException(i, j, arr[i][j]);
                }
                sum += Integer.parseInt(arr[i][j]);
            }


        }
        return sum;
    }
}

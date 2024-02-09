package Exception.EX5;

public class MyArraySizeException extends RuntimeException{
    public MyArraySizeException(String message) {
        super(message);
    }
    public MyArraySizeException(int sizeA, int sizeB) {
        super("Введите массив 4х4, сейчас: "+ sizeA + "x" + sizeB);
    }
}

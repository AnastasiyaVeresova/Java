package Exception.EX5;

public class MyArrayDataException extends RuntimeException{
    private int x,y;
    public MyArrayDataException(String message) {
        super(message);
    }
    public MyArrayDataException(int x, int y, String params) {
        super(String.format("Массив невозможно преобразовать (%d;%d) = %s", x, y, params));
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

package Exception.Ex3;

public class DivZeroException extends ArithmeticException{
    public DivZeroException(String s) {
        super(s);
    }
    public DivZeroException(){
        super("Деление на 0");
    }
}
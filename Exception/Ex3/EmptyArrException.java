package Exception.Ex3;

public class EmptyArrException extends NullPointerException{

    public EmptyArrException(String s) {
        super(s);
    }
    public EmptyArrException(){
        super("Элемент отсутствует");
    }
}

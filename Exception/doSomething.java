package Exception;

import java.awt.print.PrinterException;
import java.io.EOFException;

/*Создайте метод doSomething(), который может быть источником одного из типов
checked exceptions (тело самого метода прописывать не обязательно).
Вызовите этот метод из main и обработайте в нем исключение,
которое вызвал метод doSomething().
* */
public class doSomething {
    public static void main(String[] args) {
        try {
            doSomething();
        }
        catch (EOFException | PrinterException e){
            e.printStackTrace();
        }
    }
    public static void doSomething() throws EOFException, PrinterException {
    }
}
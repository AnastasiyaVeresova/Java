package Exception.Ex3;

import java.io.FileNotFoundException;

public class FNFoundException extends FileNotFoundException {
    public FNFoundException(String s) {
        super(s);
    }
    public FNFoundException() {
        super("Файл отсутствует");
    }
}

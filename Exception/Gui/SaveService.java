package Exception.Gui;

import java.io.FileWriter;
import java.io.IOException;

public class SaveService {
    public void save() throws IOException{
        System.out.println("Save document started...");
        try(FileWriter writer = new FileWriter("test")){
            throw new IOException("Operation failed");
        }

    }

}

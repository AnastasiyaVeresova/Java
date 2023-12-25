package oop.lessontwo.Lesson_08.Ex006.Format;

import oop.lessontwo.Lesson_08.Ex006.Document.TextDocument;

import java.io.FileWriter;
import java.io.IOException;

public class Doc extends TextFormat {
    
    @Override
    public void SaveAs(TextDocument document, String path) {
        try (FileWriter writer = new FileWriter(path + ".doc", false)) {
            writer.write("<?Doc Format>\n");
            writer.write(document.getData());
            writer.flush();
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }
}

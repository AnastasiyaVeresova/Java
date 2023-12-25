package oop.lessontwo.Lesson_08.Ex006.Format;

import oop.lessontwo.Lesson_08.Ex006.Interface.Saveable;
import oop.lessontwo.Lesson_08.Ex006.Document.TextDocument;

public abstract class TextFormat implements Saveable {
    public abstract void SaveAs(TextDocument document, String path);
}

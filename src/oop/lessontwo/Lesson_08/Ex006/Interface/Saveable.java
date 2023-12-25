package oop.lessontwo.Lesson_08.Ex006.Interface;

import oop.lessontwo.Lesson_08.Ex006.Document.TextDocument;

public interface Saveable {
    void SaveAs(TextDocument document, String path);
}

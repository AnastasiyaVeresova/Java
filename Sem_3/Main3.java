package Sem_3;

/*
Каталог товаров книжного магазина сохранен в виде двумерного списка List<ArrayList<String>> так,
что на 0й позиции каждого внутреннего списка содержится название жанра, а на остальных позициях - названия книг.
Напишите метод для заполнения данной структуры.

[
    ["Сказка", "Золотой ключик", "Репка"],
    ["Роман", "Мастер и Маргарита", "Война и Мир"],
    ["Фентези", "Гарри Поттер", "Ночной дозор"]
]

 */

import java.util.ArrayList;
import java.util.List;

public class Main3 {
    public static void main(String[] args) {
        List<List<String>> shopBook = new ArrayList<>();
        addBook(shopBook, "Сказка", "Золотой ключик");
        addBook(shopBook, "Роман", "Мастер и Маргарита");
        addBook(shopBook, "Сказка", "Репка");
        addBook(shopBook, "Фентези", "Гарри Поттер");
        addBook(shopBook, "Роман", "Война и Мир");
        addBook(shopBook, "Фентези", "Ночной дозор");

        System.out.println(shopBook);
    }

    private static void addBook(List<List<String>> shopBook, String genre, String nameBook) {
        for (List<String> bookshelf : shopBook) {
            if (bookshelf.get(0).equalsIgnoreCase(genre)) {
                bookshelf.add(nameBook);
                return;
            }
        }
        List<String> newBookshelf = new ArrayList<>();
        newBookshelf.add(genre);
        newBookshelf.add(nameBook);
        shopBook.add(newBookshelf);
    }
}

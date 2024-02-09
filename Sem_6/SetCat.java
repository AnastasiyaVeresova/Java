package Sem_6;

import java.util.HashSet;
import java.util.Set;

/*
Продумайте структуру класса Кот. Какие поля и методы будут актуальны для приложения, которое является
а) информационной системой ветеринарной клиники
б) архивом выставки котов
в) информационной системой Театра кошек Ю. Д. Куклачёва
Можно записать в текстовом виде, не обязательно реализовывать в java.

1. Реализуйте 1 из вариантов класса Cat из предыдущего задания,
можно использовать не все придуманные поля и методы. Создайте несколько экземпляров этого класса,
выведите их в консоль.
2. Добейтесь того, чтобы при выводе в консоль объекта типа Cat,
выводилась его кличка, цвет и возраст (или другие параметры на ваше усмотрение).

1. Создайте множество, в котором будут храниться экземпляры класса Cat - HashSet<Cat>.
Поместите в него некоторое количество объектов.
2. Создайте 2 или более котов с одинаковыми параметрами в полях. Поместите их во множество.
Убедитесь, что все они сохранились во множество.
3. Создайте метод public boolean equals(Object o)
Пропишите в нём логику сравнения котов по параметрам, хранимым в полях.
То есть, метод должен возвращать true, только если значения во всех полях сравниваемых объектов равны.
4. Выведите снова содержимое множества из пункта 2, убедитесь, что дубликаты удалились.
 */
public class SetCat {
    public static void main(String[] args) {
        Set<Cat> cats = new HashSet<>();

        Cat cat1 = new Cat();
        cat1.name = "Барсик";
        cat1.age = 10;
        cat1.poroda = "Персидская";
        cat1.ownerName = "Мария Ивановна";

        Cat cat2 = new Cat();
        cat2.name = "Мурзик";
        cat2.age = 9;
        cat2.poroda = "Дворняга";
        cat2.ownerName = "Кирилл Петрович";

        Cat cat3 = new Cat();
        cat3.name = "Мурка";
        cat3.age = 8;
        cat3.poroda = "Сфинкс";
        cat3.ownerName = "Семен Иванович";

        Cat cat4 = new Cat();
        cat4.name = "Рыжик";
        cat4.age = 9;
        cat4.poroda = "Британская";
        cat4.ownerName = "Вася";

        Cat cat5 = new Cat();
        cat5.name = "Рыжик";
        cat5.age = 9;
        cat5.poroda = "Британская";
        cat5.ownerName = "Вася";

        cats.add(cat1);
        cats.add(cat2);
        cats.add(cat3);
        cats.add(cat4);
        cats.add(cat5);

        printSet(findByAge(cats, 9));
    }

    static Set<Cat> findByAge(Set<Cat> cats, int minAge){
        Set<Cat> res = new HashSet<>();
        for (Cat cat: cats){
            if (cat.age >= minAge){
                res.add(cat);
            }
        }
        return res;
    }

    static void printSet(Set<Cat> cats){
        for (Cat cat: cats){
            System.out.println(cat);
        }
    }
}
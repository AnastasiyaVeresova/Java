package oop.hw_1;
/*
Проанализировать персонажей "
Крестьянин,Peasant ~ Spearman > не боевой, не лечит, не ходит, носит стрелы снайперам и арбалетчикам
Разбойник, Rogue ~ Spearman > боевой юнит, ходит, бьет в упор
Снайпер, Sniper ~ Crossbowman боевой юнит. Не перемещается, стреляет, стрелы ограничены
Колдун, Sorcerer ~ Monk > волшебник. Не перемещается, лечит, мана не ограничена
Копейщик, Spearman - боевой юнит. Перемещается на 1 клеточку за ход (кроме диагоналей).Оружие ближнего боя не ограничено, ход не ограничен
Арбалетчик, Crossbowman - боевой юнит. Умеет стрелять, не перемещается, стрелы ограничены
Монах, Monk - волшебник. Не перемещается, лечит, мана не ограничена

Для каждого определить
8 полей данных(здоровье, сила итд) 3-4 поля поведения(методов атаковать, вылечить итд). Создать абстрактный класс и иерархию
наследников. Расположить классы в пакет так, чтобы в основной программе небыло видно их полей. В не абстрактных классах
переопределить метод toString() так чтобы он возвращал название класса или имя. Создать в основной программе по одному
обьекту каждого не абстрактного класса и вывести в консоль его имя.
======================================================================================
abstract class Person {
    private String name;
    public Person(String name) {
        this.name = name;
    }
    public abstract int getHealth();
    public abstract int getStrength();
    public abstract void attack();
    public abstract void heal();
    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
class Peasant extends Person {
    private int health;
    private int strength;
    public Peasant(String name, int health, int strength) {
        super(name);
        this.health = health;
        this.strength = strength;
    }
    @Override
    public int getHealth() {
        return health;
    }
    @Override
    public int getStrength() {
        return strength;
    }
    @Override
    public void attack() {

    }
    @Override
    public void heal() {
    }
}
public class Main {
    public static void main(String[] args) {
        Person peasant = new Peasant("Крестьянин", 100, 10);
//      Person robber = new Robber("Разбойник", 80, 20);

        System.out.println(peasant.toString());
//        System.out.println(robber.toString());

    }

}
*/

import java.util.ArrayList;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        heroesWhite = generateCommand(0, 0);
        heroesBlack = generateCommand(3, 9);
        heroesWhite.forEach(n -> System.out.println(n.toString()));
        System.out.println("******************************");
        heroesBlack.forEach(n -> n.printEnemyDistance(heroesWhite));
    }
    static ArrayList<Hero> heroesWhite = new ArrayList<>();
    static ArrayList<Hero> heroesBlack = new ArrayList<>();
    static ArrayList<Hero> generateCommand(int n, int y) {
        ArrayList<Hero> commandHeroes = new ArrayList<>();
        Random random = new Random();
        int rand;


        for (int i = 0; i < 10; i++) {
            rand = random.nextInt(1, 5) + n;
//            (int) Math.random()*10;
            switch (rand) {
                case 1:
                    commandHeroes.add(new Crossbower(getName(), i, y));
                    break;
                case 2:
                    commandHeroes.add(new Monk(getName(), i, y));
                    break;
                case 3:
                    commandHeroes.add(new Pikeman(getName(), i, y));
                    break;
                case 4:
                    commandHeroes.add(new Peasant(getName(), i, y));
                    break;
                case 5:
                    commandHeroes.add(new Rogue(getName(), i, y));
                    break;
                case 6:
                    commandHeroes.add(new Sniper(getName(), i, y));
                    break;
                case 7:
                    commandHeroes.add(new Wizard(getName(), i, y));
                    break;
            }
        }
        return commandHeroes;
    }
    static String getName() {
        return NameOfHeroes.values()[new Random().nextInt(NameOfHeroes.values().length - 1)].name();
    }

}




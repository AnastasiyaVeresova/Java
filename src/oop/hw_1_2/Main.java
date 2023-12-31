package oop.hw_1_2;

import oop.hw_1_2.units.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int numberOfTeams = 10;
        createTeams(numberOfTeams);
//        System.out.println("Darkside team:");
//        System.out.println("***************************************");
//
//        darkSide.forEach(n-> System.out.println(n.toString()));
//        System.out.println("Lightside team:");
        lightSide.forEach(n-> System.out.println(n.toString()));
//        darkSide.get(1).getDistance(lightSide);
        System.out.println("***************************************");
        darkSide.forEach(n-> n.getDistance(lightSide));


    }
//        List<Person> gamePersons = new ArrayList<>();
//        Random rnd = new Random();
//        for (int i = 0; i < 10; i++) {
//            int pers = rnd.nextInt(0, 7);
//            switch (pers) {
//                case (0):
//                    gamePersons.add(new Archer(getName()));
//                    break;
//                case (1):
//                    gamePersons.add(new Monk(getName()));
//                    break;
//                case (2):
//                    gamePersons.add(new Robber(getName()));
//                    break;
//                case (3):
//                    gamePersons.add(new Sniper(getName()));
//                    break;
//                case (4):
//                    gamePersons.add(new Sorcerer(getName()));
//                    break;
//                case (5):
//                    gamePersons.add(new Villager(getName()));
//                    break;
//                case (6):
//                    gamePersons.add(new Spearman(getName()));
//                    break;
//            }
//        }
//        gamePersons.forEach(System.out::println);
//    }
    static String getName() {
        return Names.values()[new Random().nextInt(Names.values().length - 1)].toString();
    }

    static void createTeams(int numbers) {
        for (int i = 0; i < numbers; i++) {
            darkSide.add(getRandomHero(random.nextInt(3, 7),i,9));
            lightSide.add(getRandomHero(random.nextInt(4),i,0));
        }
    }
    static Person getRandomHero(int choice, int x,int y) {
        return  switch (choice) {
            case 0 -> new Monk(getName(), x, y);
            case 1 -> new Spearman(getName(), x, y);
            case 2 -> new Archer(getName(), x, y);
            case 3 -> new Villager(getName(), x, y);
            case 4 -> new Sorcerer(getName(), x, y);
            case 5 -> new Robber(getName(), x, y);
            case 6 -> new Sniper(getName(), x, y);
            default -> null;
        };
    }
    static Random random = new Random();
    static ArrayList<Person> darkSide = new ArrayList<>();
    static ArrayList<Person> lightSide = new ArrayList<>();
    static HashMap<Person, ArrayList<Double>> allDistance = new HashMap<>();
}




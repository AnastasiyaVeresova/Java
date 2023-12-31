package oop.hw_1.pers;

import java.util.ArrayList;

public class Crossbower extends Hero {
    public Crossbower(String nameHero, int posX, int posY) {
        super(75, 75, 2, new int[]{10, 15}, nameHero, posX, posY);
//        rangeMaxDamage = 4;
    }

//    Random random = new Random();
//    protected int rangeMaxDamage;
//    protected int quantityShots;


    @Override
    public String toString() {
        return "Арбалетчик: " + nameHero + ", здоровье: " + health + "/" + healthMax + ", броня: " + armor + " (" + position + ")";
    }

    @Override
    public Hero nearestEnemy(ArrayList<Hero> enemys) {
        return super.nearestEnemy(enemys);
    }

    public float minDistance (ArrayList<Hero> enemys) {
        return super.minDistance(enemys);
    }

}
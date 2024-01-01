package oop.hw_1.pers;

public class Crossbower extends Hero {

    private float minDist;

    public Crossbower(String nameHero, int posX, int posY) {
        super(75, 75, 2, new int[]{10, 15}, nameHero, posX, posY);
//        rangeMaxDamage = 4;
    }


    @Override
    public String toString() {
        return "Арбалетчик: " + nameHero + ", здоровье: " + health + "/" + healthMax + ", броня: " + armor + " (" + position + "), " + minDist;
    }
}
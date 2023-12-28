package oop.hw_1;

public class Sniper extends Hero {
    public Sniper(String nameHero, int posX, int posY) {
        super(75, 75, 2, new int[]{10, 15}, nameHero, posX, posY);
//        rangeMaxDamage = 4;
    }

    protected Vector2 position;
    protected  int rangeMaxDamage;

    @Override
    public String toString() {
        return ("Снайпер: " + nameHero + ", здоровье: " + health + "/" + healthMax + ", броня: " + armor);
    }
}

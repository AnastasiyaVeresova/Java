package oop.hw_1;

public class Wizard extends Hero {
    public Wizard(String nameHero, int posX, int posY) {
        super(50, 50, 1, new int[]{-35, -30}, nameHero, posX, posY);
//        rangeMaxDamage = 4;
    }

    protected Vector2 position;
    protected  int rangeMaxDamage;




    @Override
    public String toString() {
        return ("Колдун: " + nameHero + ", здоровье: " + health + "/" + healthMax + ", броня: " + armor);
    }
}

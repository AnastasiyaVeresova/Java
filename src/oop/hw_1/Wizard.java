package oop.hw_1;

public class Wizard extends Hero {
    public Wizard(String nameHero) {
        super(50,
                50,
                1,
                new int[]{-35, -30}, nameHero);
    }

    @Override
    public String toString() {
        return ("Колдун: " + nameHero + " здоровье: " + health + "/" + healthMax + " броня: " + armor);
    }
}

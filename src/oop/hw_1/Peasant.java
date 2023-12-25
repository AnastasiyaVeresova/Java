package oop.hw_1;

public class Peasant extends Hero {
    public Peasant(String nameHero) {
        super(100,
                100,
                0,
                new int[]{0, 0}, nameHero);
    }

    @Override
    public String toString() {
        return ("Крестьянин: " + nameHero + " здоровье: " + health + "/" + healthMax + " броня: " + armor);
    }
}

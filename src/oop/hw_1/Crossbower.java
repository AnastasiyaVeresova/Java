package oop.hw_1;

public class Crossbower extends Hero {
    public Crossbower(String nameHero) {
        super(75,
                75,
                2,
                new int[]{10, 15}, nameHero);
        rangeMaxDamage = 4;
    }
    int rangeMaxDamage;
    @Override
    public String toString() {
        return ("Арбалетчик: " + nameHero + " здоровье: " + health + "/" + healthMax + " броня: " + armor);
    }
}

package oop.hw_1_2.units;

public class Sorcerer extends Person{
    public Sorcerer(String name, int x, int y) {
        super(name,
                false,
                false,
                true,
                90,
                1000,
                90,
                1000,
                0,
                0,
                new int[] {-10, -8},
                x, y);
    }

    @Override
    public String toString() {
        return "Sorcerer: " + name + " " + position;
    }
}
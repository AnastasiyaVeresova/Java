package oop.hw_1_2.units;

public class Archer extends Person {
    public Archer(String name, int x, int y) {
        super(name,
                true,
                false,
                true,
                100,
                10,
                100,
                10,
                0,
                0,
                new int[]{10, 13},
                x, y);
    }

    @Override
    public String toString() {
        return "Archer: " + name + " " + position;
    }

}
package oop.hw_1_2.units;

public class Sniper extends Person{
    public Sniper(String name, int x, int y) {
        super(name,
                true,
                true,
                true,
                100,
                10,
                100,
                10,
                0,
                0,
                new int[] {10, 13},
                x, y);
    }

    public String toString() {
        return "Sniper: " + name + " " + position;
    }
}
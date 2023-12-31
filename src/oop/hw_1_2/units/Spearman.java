package oop.hw_1_2.units;

public class Spearman extends Person{
    public Spearman(String name, int x, int y) {
        super(name,
                true,
                true,
                true,
                150,
                0,
                150,
                0,
                0,
                0,
                new int[] {12, 15},
                x, y);
    }

    @Override
    public String toString() {
        return "Spearman: " + name + " " + position;
    }
}

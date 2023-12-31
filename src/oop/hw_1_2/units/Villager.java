package oop.hw_1_2.units;

public class Villager extends Person{
    public Villager(String name, int x, int y) {
        super(name,
                true,
                false,
                false,
                70,
                1,
                70,
                1,
                0,
                0,
                new int[] {0},
                x, y);
    }

    @Override
    public String toString() {
        return "Villager: " + name + " " + position;
    }
}
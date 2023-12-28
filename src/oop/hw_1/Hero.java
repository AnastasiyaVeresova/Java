package oop.hw_1;

import java.util.ArrayList;

public abstract class Hero {
    protected int health, healthMax, armor;
    protected Vector2 position;

    protected int[] damage;
    protected String nameHero;

    public Hero(int health, int healthMax, int armor, int[] damage, String nameHero, int posX, int posY) {
        this.health = health;
        this.healthMax = healthMax;
        this.armor = armor;
        this.damage = damage;
        this.nameHero = nameHero;
        this.position = new Vector2(posX, posY);
    }
    public void printEnemyDistance(ArrayList<Hero> enemys) {
        enemys.forEach(n-> System.out.print(position.rangeEnemy(n.position) + ", "));
        System.out.println();
    }
}



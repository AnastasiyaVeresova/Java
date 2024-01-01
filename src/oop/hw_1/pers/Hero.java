package oop.hw_1.pers;

import java.util.ArrayList;
import java.util.Collections;

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
        System.out.print(nameHero + ": ");
        enemys.forEach(n -> System.out.print(position.rangeEnemy(n.position) + ", "));

        System.out.println();
        System.out.println("Ближайший противник: " + nearestEnemy(enemys) + ", на расстоянии: " + minDistance(enemys));

    }

    public float minDistance(ArrayList<Hero> enemys) {
        ArrayList<Float> dist = new ArrayList<>();
        float minDist = 0;
        for (Hero hero : enemys) {
            enemys.forEach(n -> dist.add(position.rangeEnemy(n.position)));
            minDist = Collections.min(dist);
        }
        return minDist;
    }

    public Hero nearestEnemy(ArrayList<Hero> enemys) {
        Hero hero = enemys.get(0);
        for (int i = 0; i < enemys.size(); i++) {
            if (this.position.rangeEnemy(enemys.get(i).position) < this.position.rangeEnemy(hero.position)) {
                hero = enemys.get(i);
            }
        }
        return hero;
    }
}
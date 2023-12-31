package oop.hw_1_2.units;

import java.util.ArrayList;

public abstract class Person {
    protected String name;
    protected boolean isMovable;
    protected int maxHealth;
    protected int maxAbility;
    protected int currentHealth;
    protected  int currentAbility;
    protected int healthRegen;
    protected boolean isMelee;
    protected boolean isMilitary;
    protected int abilityRegen;
    protected int[] damage;
    protected Coordinates position;


    public Person(String name, boolean isMovable, boolean isMelee, boolean isMilitary, int maxHealth, int maxAbility, int currentHealth, int currentAbility, int abilityRegen, int healthRegen, int [] damage, int x, int y) {
    this.name = name;
    this.isMovable = isMovable;
    this.isMelee = isMelee;
    this.isMilitary = isMilitary;
    this.maxHealth = maxHealth;
    this.maxAbility = maxAbility;
    this.currentHealth = currentHealth;
    this.currentAbility = currentAbility;
    this.abilityRegen = abilityRegen;
    this.healthRegen = healthRegen;
    this.damage = damage;
    this.position = new Coordinates(x, y);


    }
    public void getDistance(ArrayList<Person> enemy) {
        for (Person person : enemy) {
            System.out.printf(name + " %.2f; ", position.distance(person.position));

        }
        System.out.println();
    }
}


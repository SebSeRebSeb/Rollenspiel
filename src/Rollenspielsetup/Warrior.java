package Rollenspielsetup;

import java.util.Random;

public class Warrior extends Character {
    private int stamina;
    private int strength;
    private Random rand;

    public Warrior(String name) {
        super(name);
        setStamina();
        setStrength();
        setHp();
    }

    public Warrior(int id, String name, int hp) {
        super(id, name, hp);
        setStamina();
        setStrength();
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina() {
        this.stamina = 10+rand.nextInt(40);
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength() {
        this.strength = 1+rand.nextInt(9);
    }

    public void setHp(){
        this.hp = rand.nextInt(100)+100;
    }

    public int getHp(){
        return this.hp;
    }
}

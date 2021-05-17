package Rollenspielsetup;

import java.util.Random;

public class Warrior extends Character {
    private int stamina;
    private int strength;
    private Random rand;

    public Warrior(String name) {
        super(name);
        setStamina(stamina);
        setStrength(strength);
        setHp(hp);
    }

    public Warrior(int id, String name, int hp, int stamina, int strength) {
        super(id, name, hp);
        this.stamina = stamina;
        this.strength = strength;
        setHp(hp);
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setHp(int hp){
        if((hp>=100)&&(hp<=200)) {
            this.hp=hp;
        } else {
            this.hp = rand.nextInt(100)+100;
        }
    }

    public int getHp(){
        return this.hp;
    }
}

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
        setHp();
    }

    public Warrior(String name, int hp, int stamina, int strength) {
        super(name, hp);
        this.stamina = stamina;
        this.strength = strength;
        setHp();
    }

    public int getStamina() {
        return stamina ;
    }

    public void setStamina(int stamina) {
        this.stamina = 10+rand.nextInt(41);
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = 1+rand.nextInt(10);
    }


    @Override
    public void setHp(){
        Random random = new Random();
        int hp = 100+random.nextInt(101);
        this.hp = hp;
    }

//    public void setHp(){
//        if((hp>=100)&&(hp<=200)) {
//            this.hp=hp;
//        } else {
//            this.hp = rand.nextInt(100)+100;
//        }
//    }

    public int getHp(){
        return this.hp;
    }
}

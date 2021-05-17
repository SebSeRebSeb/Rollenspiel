package Rollenspielsetup;

import java.util.Random;

public class Warrior extends Character implements Attacker{
    private int stamina;
    private int strength;
    private Random rand;

    public Warrior(String name) {
        super(name);
        setStamina();
        setStrength(strength);
        setHp();
    }

    public Warrior(String name, int hp, int stamina, int strength) {
        super(name, hp);
        this.stamina = stamina;
        this.strength = strength;
        setHp();
    }

    // Attack method

    @Override
    public void attack(Character character) {
        int damage;
        if(this.stamina >= 5) {
            damage = this.getStrength();
            this.stamina -= 5;
            System.out.println(this.getName() + " attacks " + character.getName() + " with a Heavy Attack for " + damage + " of damage!");
        } else {
            damage = (this.getStrength())/2;
            this.stamina +=1;
            System.out.println(this.getName() + " attacks " + character.getName() + " with a Weak Attack for " + damage + " of damage!");
        }
        character.takeDamage(damage);
    }


    //setter + getter

    public int getStamina() {
        return stamina ;
    }

    public void setStamina() {
        Random random = new Random();
        this.stamina = 10+random.nextInt(41);
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        Random random = new Random();
        this.strength = 1+random.nextInt(10);
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

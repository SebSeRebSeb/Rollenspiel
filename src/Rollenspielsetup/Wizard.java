package Rollenspielsetup;

import java.util.Random;

public class Wizard extends Character implements Attacker{
    private int mana;
    private int intelligence;


    public Wizard(String name) {
        super(name);
        setHp();
        setMana();
        setIntelligence();
    }

    public Wizard( String name, int hp) {
        super(name, hp);
        setMana();
        setIntelligence();
    }

    //Attack Method
    @Override
    public void attack(Character character) {
        int damage;
        if(this.mana >= 5) {
            damage = this.getIntelligence();
            this.mana -= 5;
            System.out.println(this.getName() + " attacks " + character.getName() + " with a Fireball for " + damage + " of damage!");
        } else {
            damage = 2;
            this.mana += 1;
            System.out.println(this.getName() + " attacks " + character.getName() + " with a Staff Hit for " + damage + " of damage!");
        }
        character.takeDamage(damage);
    }


    // getter + setter
    public void setMana() {
        Random random = new Random();
        int mana = 10+random.nextInt(50);
        this.mana = mana;
    }

    public void setIntelligence(){
        Random random = new Random();
        int intelligence = 1+random.nextInt(50);
        this.intelligence = intelligence;

    }

    @Override
    public void setHp(){
        Random random = new Random();
        int hp = 50+random.nextInt(50);
        this.hp = hp;
    }
    public int getHp(){
        return this.hp;
    }


    public int getMana() {
        return this.mana;
    }


    public int getIntelligence() {
        return this.intelligence;
    }
}



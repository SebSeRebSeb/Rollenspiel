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

    //Attack Methods
    @Override
    public int attack() {
        int damage;
        if(mana >= 5) {
            damage = intelligence;
            mana -= 5;
            System.out.println(this.getName() + " attacks you with a Fireball for " + damage + " of damage!");
        } else {
            damage = 2;
            mana += 1;
            System.out.println(this.getName() + " attacks you with a Staff Hit for " + damage + " of damage!");
        }
        return damage;
    }



    @Override
    public void takeDamage(int damage){
        hp -= damage;
        if(hp <= 0) {
            setAlive(false);
            System.out.println(this.getName() + " has been slaughtered!");
        }
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



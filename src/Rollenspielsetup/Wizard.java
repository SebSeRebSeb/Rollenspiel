package Rollenspielsetup;

import java.util.Random;

public class Wizard extends Character {
    private int mana;
    private int intelligence;


    public Wizard(String name) {
        super(name);
        setMana();
        setIntelligence();
    }

    public Wizard(int id, String name, int hp) {
        super(id, name, hp);
        setMana();
        setIntelligence();
    }
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
        int hp = 50+random.nextInt(100);
        this.hp = hp;
    }


    public int getMana() {
        return this.mana;
    }

    public int getIntelligence() {
        return this.intelligence;
    }
}



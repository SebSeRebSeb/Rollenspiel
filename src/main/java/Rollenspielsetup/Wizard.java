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

    public Wizard( String name, int hp, int mana, int intelligence) {
        super(name);
        setMana(mana);
        setIntelligence(intelligence);
        setHp(hp);
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
        int mana = 10+random.nextInt(41);
        this.mana = mana;
    }
    public void setMana(int mana){
        if (mana >=10 && mana <51){
            this.mana = mana;
        }else {
            setMana();
            System.out.println("The entered mana was not in the given parameters. It was randomly set between 10 and 50");
        }
    }


    public void setIntelligence(){
        Random random = new Random();
        int intelligence = 1+random.nextInt(51);
        this.intelligence = intelligence;

    }
    public void setIntelligence(int intelligence){
        if (intelligence >=1 && intelligence <51){
            this.intelligence = intelligence;
        }else {
            setIntelligence();
            System.out.println("The entered intelligence was not in the given parameters. It was randomly set between 1 and 50");
        }
    }


    @Override
    public void setHp(){
        Random random = new Random();
        int hp = 50+random.nextInt(51);
        this.hp = hp;
    }
    public void setHp(int hp){
        if (hp >=50 && hp <101){
            this.hp = hp;
        }else {
            setHp();
            System.out.println("The entered hp was not in the given parameters. It was randomly set between 50 and 100");
        }
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



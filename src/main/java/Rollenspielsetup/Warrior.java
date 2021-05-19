package Rollenspielsetup;

import java.util.Random;

public class Warrior extends Character implements Attacker{
    private int stamina;
    private int strength;

    public Warrior(String name){
        super(name);
        setStrength();
        setStamina();
        setHp();
    }

    public Warrior(String name, int hp, int stamina, int strength) {
        super(name);
        setStamina(stamina);
        setStrength(strength);
        setHp(hp);
        //Setter mit Propertyprüfung ergänzen
    }

    // Attack method
    @Override
    public void attack(Character character) {
        int damage;
        if(this.isAlive && this.stamina >= 5) {
            damage = this.getStrength();
            this.stamina -= 5;
            System.out.println(this.getName() + " attacks " + character.getName() + " with a Heavy Attack for " + damage + " of damage!");
        } else if (this.isAlive) {
            damage = (this.getStrength())/2;
            this.stamina +=1;
            System.out.println(this.getName() + " attacks " + character.getName() + " with a Weak Attack for " + damage + " of damage!");
        } else {
            damage = 0;
        }
        //damage taken by input character
        character.hp = character.getHp() - damage;
        if (character.getHp() <= 0) {
            character.setAlive(false);
            System.out.println(character.getName() + " has been slaughtered!");
        }
    }

    //setter + getter

    public int getStamina() {
        return stamina ;
    }

    public void setStamina() {
        Random random = new Random();
        this.stamina = 10+random.nextInt(41);
    }
    public void setStamina(int stamina){
        if (stamina >=10 && stamina <51){
            this.stamina = stamina;
        }else {
            setStamina();
            System.out.println("The entered stamina was not in the given parameters. It was randomly set between 10 and 40");
        }
    }


    public int getStrength() {
        return strength;
    }

    public void setStrength() {
        Random random = new Random();
        this.strength = 1+random.nextInt(10);
    }
    public void setStrength(int strength){
        if (strength >=1 && strength <11){
            this.strength = strength;
        }else {
            setStrength();
            System.out.println("The entered strength was not in the given parameters. It was randomly set between 1 and 10");
        }
    }


    @Override
    public void setHp(){
        Random random = new Random();
        int hp = 100+random.nextInt(101);
        this.hp = hp;
    }
    @Override
    public void setHp(int hp){
        if (hp >=100 && hp <201){
            this.hp = hp;
        }else {
            setHp();
            System.out.println("The entered hp was not in the given parameters. It was randomly set between 100 and 200");
        }
    }

    public int getHp(){
        return this.hp;
    }
}

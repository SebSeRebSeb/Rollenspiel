package Rollenspielsetup;

import java.util.UUID;

public abstract class Character {

    private String id = UUID.randomUUID().toString();;
    private String name;
    protected int hp;
    protected boolean isAlive;
    private int start = 0;

    public Character(String name) {

        setName(name);
        this.isAlive = true;
    }

    public Character(String name, int hp) {

        setName(name);
        setHp(hp);
        this.isAlive = true;
    }


    // Methods
    public void takeDamage(int damage) {
        setHp(getHp()-damage);
        if(getHp() <= 0) {
            setAlive(false);
            System.out.println(getName() + " has been slaughtered!");
        }
    }

    // setters + getters

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public void setHp(int hp) {
        this.hp=hp;
    }

    public void setHp(){

    }

    public int getHp() {
        return hp;
    }
}

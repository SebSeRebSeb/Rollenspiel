package Rollenspielsetup;

import java.util.UUID;

public abstract class Character {

    private String id = UUID.randomUUID().toString();;
    private String name;
    protected int hp;
    private boolean isAlive;
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
    public  void setHp(){

    }

}

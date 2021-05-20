package Rollenspielsetup;

import java.util.Objects;
import java.util.UUID;

public abstract class Character {

    private String id = UUID.randomUUID().toString();
    protected String name;
    protected int hp;
    protected boolean isAlive;

    public Character() {

        setName(Names.getRandomName());
        this.isAlive = true;
    }

    public Character(String name, int hp) {

        setName(name);
        setHp(hp);
        this.isAlive = true;
    }


    // setters + getters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id=id;
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
        this.hp = hp;
    }

    public void setHp() {

    }

    public int getHp() {
        return hp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Character character = (Character) o;
        return hp == character.hp && isAlive == character.isAlive && Objects.equals(id, character.id) && Objects.equals(name, character.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, hp, isAlive);
    }

    public abstract void attack(Character character);

}

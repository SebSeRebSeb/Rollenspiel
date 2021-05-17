package Rollenspielsetup;

public abstract class Character {

    private int id;
    private String name;
    protected int hp;
    private boolean isAlive;

    public Character(String name) {
        setId(id);
        setName(name);
        this.isAlive = true;
    }

    public Character(int id, String name, int hp) {
        setId(id);
        setName(name);
        this.isAlive = true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setHp(){
    }

}

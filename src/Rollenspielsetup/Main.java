package Rollenspielsetup;

public class Main {
    public static void main(String[] args) {
        Wizard steve = new Wizard("Steve");
        Warrior steve4 = new Warrior("Steve4");



        System.out.println(steve.getId());
        System.out.println(steve4.getId());

        System.out.println(steve4.getStrength());
        steve.takeDamage(steve4.attack());

    }
}

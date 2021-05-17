package Rollenspielsetup;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Character> partyOne = new ArrayList<>();
        ArrayList<Character> partyTwo = new ArrayList<>();
        Menu menu = new Menu();
        Wizard steve = new Wizard("Steve");
        Warrior klaus = new Warrior("Klaus");

//        -- Loop to see how Attack-Method works --
//        while(klaus.isAlive()){
//            steve.attack(klaus);
//        }


        menu.startMenu(partyOne,partyTwo);

        System.out.println(partyOne.get(0).getId() +"-"+ partyOne.get(0).getName());
        System.out.println(partyTwo.get(0).getId() +"-"+ partyTwo.get(0).getName());

//        System.out.println(steve.getId());
//        System.out.println(steve4.getId());
//
//        System.out.println(steve4.getStrength());
//        steve.takeDamage(steve4.attack());

    }
}

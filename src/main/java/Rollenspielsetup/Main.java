package Rollenspielsetup;



public class Main {
    public static void main(String[] args) {
        Party partyOne = new Party();
        Party partyTwo = new Party();
        Graveyard graveyard = new Graveyard();
        Menu menu = new Menu();
        Wizard steve = new Wizard();
        Warrior klaus = new Warrior("Klaus",12, 12, 12);

        //  -- Loop to see how Attack-Method works --
//        while (klaus.isAlive()) {
//            steve.attack(klaus);
//        }


        menu.startMenu(partyOne,partyTwo, graveyard);


//        System.out.println(steve.getId());
//        System.out.println(steve4.getId());
//
//        System.out.println(steve4.getStrength());
//        steve.takeDamage(steve4.attack());

    }
}

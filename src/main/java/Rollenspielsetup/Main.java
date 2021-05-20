package Rollenspielsetup;

import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Party partyOne = new Party();
        Party partyTwo = new Party();
        Graveyard graveyard = new Graveyard();
        Menu menu = new Menu();


        menu.startMenu(partyOne,partyTwo, graveyard);

    }
}

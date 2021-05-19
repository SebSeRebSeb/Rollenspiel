package Rollenspielsetup;

import java.util.ArrayList;

public class Graveyard {
    private ArrayList<Character> graveyard = new ArrayList<>();

    // Constructor

    public  Graveyard(){
    }


    public Graveyard(ArrayList<Character> graveyard) {
        this.graveyard = graveyard;
    }

    public void died(Character deadChar){
        this.graveyard.add(deadChar);
        System.out.println("The "+ deadChar.getClass() + " " + deadChar.getName() + "passes and is now in the Graveyard");
    }

    // function muss mit remove from party zusammen in Atack rein -> if hp =< 0


    //Getter & Setter


    public ArrayList<Character> getGraveyard() {
        return graveyard;
    }

    public void setGraveyard(ArrayList<Character> graveyard) {
        this.graveyard = graveyard;
    }
}

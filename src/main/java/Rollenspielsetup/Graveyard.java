package Rollenspielsetup;

import java.util.ArrayList;

public class Graveyard {
    private ArrayList<Character> graveyard = new ArrayList<>();

    // Constructor

    public Graveyard() {
    }


    public Graveyard(ArrayList<Character> graveyard) {
        this.graveyard = graveyard;
    }

    public void died(Character deadChar) {
        this.graveyard.add(deadChar);
        System.out.println("The " + deadChar.getClass() + " " + deadChar.getName() + "passes and is now in the Graveyard");
    }

    // function muss mit remove from party zusammen in Atack rein -> if hp =< 0

    public String seeCasualties() {
        String casualties = "In the big clash of forces died the following Characters: " + "\n";
        String begin = null;
        for (int i = 0; i < this.graveyard.size(); i++) {

            begin = begin + this.graveyard.get(i).getId() + ";" + this.graveyard.get(i).getName() + ";" +
                    this.graveyard.get(i).getClass() + "\n";
        }
        return  casualties + begin;
    }


    //Getter & Setter

    public ArrayList<Character> getGraveyard() {
        return graveyard;
    }

    public void setGraveyard(ArrayList<Character> graveyard) {
        this.graveyard = graveyard;
    }
}

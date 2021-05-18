package Rollenspielsetup;

import java.util.ArrayList;

public class Party {
    private ArrayList<Character> party= new ArrayList<>();

    public Party(){

    }

    public Party(ArrayList<Character> party) {
        this.party = party;
    }

    public ArrayList<Character> getParty() {
        return party;
    }

    public void setParty(ArrayList<Character> party) {
        this.party = party;
    }

    public void add(Character character){
        this.party.add(character);
    }

    public void remove(Character character){
        this.party.remove(character);
    }



}

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
        if(this.party.contains(character)) {
            this.party.remove(character);
        } else {
            System.out.println("Der Charakter existiert nicht!");
        }
    }

    public void importParty(String inputString){
        String[] parts = inputString.split("\n");
        String[] zeile;
        for(int i=0;i<parts.length;i++){
           zeile=parts[i].split(";");
           switch(zeile[5]){
               case "Warrior":
                   Warrior warrior = new Warrior(zeile[1],Integer.parseInt(zeile[2]),Integer.parseInt(zeile[3]),Integer.parseInt(zeile[4]));
                   warrior.setId(zeile[0]);
                   this.party.add(warrior);
                   break;
               case "Wizard":
                   Wizard wizard = new Wizard(zeile[1],Integer.parseInt(zeile[2]),Integer.parseInt(zeile[3]),Integer.parseInt(zeile[4]));
                   wizard.setId(zeile[0]);
                   this.party.add(wizard);
                   break;
               default:
                   System.err.println("Charaktertyp exisitiert nicht!");
           }
        }
    }

    public String exportParty(){
        //initialisiere ausgabe
        String ausgabe = "";
        for (int j=0; j<this.party.size();j++){
            if(this.party.get(j) instanceof Warrior) {
                ausgabe = ausgabe + this.party.get(j).getId() + ";" + this.party.get(j).getName() +";" +
                                    this.party.get(j).getHp() + ";" + ((Warrior) this.party.get(j)).getStamina() + ";" +
                                    ((Warrior) this.party.get(j)).getStrength() + ";Warrior\n";
            }
            if(this.party.get(j) instanceof Wizard) {
                ausgabe = ausgabe + this.party.get(j).getId() + ";" + this.party.get(j).getName() +";" +
                        this.party.get(j).getHp() + ";" + ((Wizard) this.party.get(j)).getMana() + ";" +
                        ((Wizard) this.party.get(j)).getIntelligence() + ";Wizard\n";
            }
        }
        return ausgabe;
    }
}

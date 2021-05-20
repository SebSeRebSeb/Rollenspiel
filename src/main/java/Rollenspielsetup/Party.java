package Rollenspielsetup;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Party {
    private ArrayList<Character> party = new ArrayList<>();

    public Party() {

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

    public void add(Character character) {
        for (int i = 0; i < party.size(); i++) {
            if (party.get(i).getName().equals(character.getName())) {
                character.setName(character.getName() + "jr");

//                if ((party.get(i).getName()).equals(character.getName())){
//                    character.setName(character.getName() + "jrJR");
//                }
                String fileName = "rollenspiel_namen.csv";
                File file = new File(fileName);
                List<String> result = new ArrayList<>();

                try {

                    Scanner inputStream = new Scanner(file);
                    while (inputStream.hasNext()) {
                        String[] data = inputStream.next().split(" ");
                        Collections.addAll(result, data);
                    }
                    inputStream.close();

                } catch (FileNotFoundException e) {

                    e.printStackTrace();
                }
                result.add(character.getName());


                try {
                    FileWriter writer = new FileWriter("rollenspiel_namen.csv");
                    for (String name : result) {
                        writer.write(name + "\n");
                    }
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                this.party.add(character);
                return;

            }


        }
        this.party.add(character);
    }


    public void remove(Character character) {
        if (this.party.contains(character)) {
            this.party.remove(character);
        } else {
            System.out.println("Character doesn't exist!");
        }
    }

    public void importParty(String inputString) {
        String[] parts = inputString.split("\n");
        String[] zeile;
        for (int i = 0; i < parts.length; i++) {
            zeile = parts[i].split(";");
            switch (zeile[5]) {
                case "Warrior":
                    Warrior warrior = new Warrior(zeile[1], Integer.parseInt(zeile[2]), Integer.parseInt(zeile[3]), Integer.parseInt(zeile[4]));
                    warrior.setId(zeile[0]);
                    this.party.add(warrior);
                    break;
                case "Wizard":
                    Wizard wizard = new Wizard(zeile[1], Integer.parseInt(zeile[2]), Integer.parseInt(zeile[3]), Integer.parseInt(zeile[4]));
                    wizard.setId(zeile[0]);
                    this.party.add(wizard);
                    break;
                default:
                    System.err.println("Character type doesn't exist!");
            }
        }
    }

    public String exportParty() {
        //initialisiere ausgabe
        String ausgabe = "";
        for (int j = 0; j < this.party.size(); j++) {
            if (this.party.get(j) instanceof Warrior) {
                ausgabe = ausgabe + this.party.get(j).getId() + ";" + this.party.get(j).getName() + ";" +
                        this.party.get(j).getHp() + ";" + ((Warrior) this.party.get(j)).getStamina() + ";" +
                        ((Warrior) this.party.get(j)).getStrength() + ";Warrior\n";
            }
            if (this.party.get(j) instanceof Wizard) {
                ausgabe = ausgabe + this.party.get(j).getId() + ";" + this.party.get(j).getName() + ";" +
                        this.party.get(j).getHp() + ";" + ((Wizard) this.party.get(j)).getMana() + ";" +
                        ((Wizard) this.party.get(j)).getIntelligence() + ";Wizard\n";
            }
        }
        return ausgabe;
    }
}

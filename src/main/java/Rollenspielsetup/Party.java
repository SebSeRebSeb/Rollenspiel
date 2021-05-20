package Rollenspielsetup;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
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
                character.setName(character.getName() + "_Jr");
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

    public void importParty(String input) {

        String fileName = input;
        File file = new File(fileName);
        try {
            // -Datei mit Scanner auslesen
            Scanner inputStream = new Scanner(file);

            // hashNext() loops line-by-line
            while (inputStream.hasNext()) {
                //read single line, put in string
                String[] zeile = inputStream.next().split(";");
                if (zeile.length > 1) {


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

            inputStream.close();
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        }

    }


    public void exportParty(String inputFile) {
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
        // Party wird in eine Datei geschrieben
        try {

            FileWriter fw = new FileWriter(inputFile);
            fw.write(ausgabe);
            fw.close();
        } catch (IOException e) {
            System.out.println(e);
        }

    }

    @Override
    public String toString() {
        return "Party{" +
                "party=" + party +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Party party1 = (Party) o;
        return Objects.equals(party, party1.party);
    }

    @Override
    public int hashCode() {
        return Objects.hash(party);
    }
}

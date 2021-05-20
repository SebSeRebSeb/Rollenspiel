package Rollenspielsetup;


import com.sun.jdi.Type;

import java.util.Arrays;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Menu {

    // game interface
    public void startMenu(Party partyOne, Party partyTwo, Graveyard graveyard) {
        String userInput=null;

        System.out.println("");
        showTitle("DKB-RPG-SIMULATOR II");
        System.out.println("");
        showTitle("Start-Menu");
        System.out.println("");
        // check how parties should be created and filled with Characters (manually, from imported csv file or randomly)
        System.out.println("Press the specified key (C,L or R) to choose the parties");
        System.out.println("");
        System.out.println("1) Create new parties (C)");
        System.out.println("2) Import parties (L)");
        System.out.println("3) Random fight (R)");
        // check User input for validity
        userInput=getValidatedUserInput(new String[]{"C","L","R"},"User-Input: ",
                    "Input not accepted. Please choose between C,L and R.");
        switch (userInput) {
                case "C":
                    System.out.println("Party will be created!");
                    createParty(partyOne, partyTwo);
                    exportParty(partyOne, partyTwo);
                    break;
                case "L":
                    System.out.println("Party will be imported!");
                    importParty(partyOne, partyTwo);
                    break;
                case "R":
                    System.out.println("Random mode!");
                    randomParties(partyOne, partyTwo);
                    break;
        }
        // let the game begin!!
        System.out.println("");
        showTitle("!!The game starts!!");
        System.out.println("");
        // choose characters
        while (!partyOne.getParty().isEmpty() && !partyTwo.getParty().isEmpty()) {
            System.out.println("");
            showTitle("Party One");
            System.out.println("");
            Character char1 = chooseCharacter(partyOne);
            System.out.println("");
            showTitle("Party Two");
            System.out.println("");
            Character char2 = chooseCharacter(partyTwo);
            System.out.println("");
            showTitle("!!The fight starts!!");
            System.out.println("");
            // let characters fight
            fight(char1, char2, graveyard, partyOne, partyTwo);
        }
        System.out.println("");
        showTitle("The game is over!");
        System.out.println("");
        // show result of battle
        if (partyTwo.getParty().isEmpty() && partyOne.getParty().isEmpty()) {
            showTitle("It's a TIE !");
        } else if (partyTwo.getParty().isEmpty()) {
            showTitle("Party 1 won!");
        } else if (partyOne.getParty().isEmpty()) {
            showTitle("Party 2 won!");
        }

    }

    // set size of parties and fill with characters (via User input)
    public void createParty(Party partyOne, Party partyTwo) {
        Integer groupSize;
        String userInput = null;

        System.out.println("");
        showTitle("Create new parties");
        System.out.println("");
        System.out.println("Choose the size of the parties (1-10)");
        String[] validInput = new String[]{"1","2","3","4","5","6","7","8","9","10"};
        userInput=getValidatedUserInput(validInput,"User-Input: ",
                "Input not accepted. Only NUMERIC values between 1 and 10 are accepted.");
        groupSize = Integer.parseInt(userInput);
            System.out.println("");
            showTitle("Party One");
            System.out.println("");
            for (int i = 0; i < groupSize; i++) {
                System.out.println("##################Create " + (i + 1) + ". Character##############");
                addCharactertoParty(partyOne);
            }
            System.out.println("");
            showTitle("Party Two");
            System.out.println("");
            for (int i = 0; i < groupSize; i++) {
                System.out.println("##################Create " + (i + 1) + ". Character##############");
                addCharactertoParty(partyTwo);
            }
        }

    // import party from csv-file
    public void importParty(Party partyOne, Party partyTwo) {
        partyOne.importParty("partyOne.csv");
        System.out.println("Party One has been successfully imported!");
        partyTwo.importParty("partyTwo.csv");
        System.out.println("Party Two has been successfully imported!");
    }

    // export party to csv-file
    public void exportParty(Party partyOne, Party partyTwo) {
        Scanner sc = new Scanner(System.in);
        boolean isValidInput = false;

        while (!isValidInput) {
            System.out.print("Do you wish to export the created parties (J/N)?: ");
            switch (sc.next().toUpperCase()) {
                case "J":
                    partyOne.exportParty("partyOne.csv");
                    partyTwo.exportParty("partyTwo.csv");
                    System.out.println("Party One has been successfully exported!");
                    System.out.println("Party Two has been successfully exported!");
                    isValidInput = true;
                    break;
                case "N":
                    isValidInput = true;
                    break;
                default:
                    System.out.println("Input not accepted. Please choose between 1) (=J) and 2) (=N).");
            }
        }

    }

    // generate a party of certain size (user input) and fill in with random Characters (Wizards, Warriors)
    public void randomParties(Party partyOne, Party partyTwo) {
        Random random = new Random();
        int iteration = random.nextInt(11);
        System.out.println("Parties of size " + iteration + " will be created!");
        Character newCharacter;
        int randomNumber;
        for (int k = 0; k < iteration; k++) {
            randomNumber = random.nextInt(2);
            if (randomNumber == 0) {
                newCharacter = new Wizard();
                partyOne.add(newCharacter);
                System.out.println("Wizard " + newCharacter.getName() + " was created!");
            } else {
                newCharacter = new Warrior();
                partyOne.add(newCharacter);
                System.out.println("Warrior " + newCharacter.getName() + " was created!");
            }
            randomNumber = random.nextInt(1);
            if (randomNumber == 0) {
                newCharacter = new Wizard();
                partyTwo.add(newCharacter);
                System.out.println("Wizard " + newCharacter.getName() + " was created!");
            } else {
                newCharacter = new Warrior();
                partyTwo.add(newCharacter);
                System.out.println("Warrior " + newCharacter.getName() + " was created!");
            }
        }

    }

    // add a Character to a certain party, User Input to decide whether Wizard (1) or Warrior (2) is created
    public void addCharactertoParty(Party party) {
        Scanner sc = new Scanner(System.in);
        String inputType;
        boolean validInput = false;

        //Input for type of character
        while (!validInput) {
            System.out.print("Type of character (1=Wizard;2=Warrior): ");
            inputType = sc.next();

            switch (inputType) {
                case "1":
                    Wizard wizard = new Wizard();
                    party.add(wizard);
                    System.out.println("Wizard " + wizard.getName() + " was created!");
                    validInput = true;
                    break;
                case "2":
                    Warrior warrior = new Warrior();
                    party.add(warrior);
                    System.out.println("Warrior " + warrior.getName() + " was created!");
                    validInput = true;
                    break;
                default:
                    System.out.println("Input not accepted. Choose between Wizard(1) and Warrior(2)");
            }
        }
    }

    // choose character via user input to let the fight against each other
    public Character chooseCharacter(Party party) {
        Scanner sc = new Scanner(System.in);
        Integer inputNumber;

        boolean validInput = false;

        if (party.getParty().size() > 1) {
            System.out.println("Choose your fighter:");
            for (int i = 0; i < party.getParty().size(); i++) {
                System.out.println((i + 1) + ". Character " + party.getParty().get(i).getName() + " (Type: " + getType(party.getParty().get(i)) + ")");
                showStats(party.getParty().get(i));
            }
            // incl. check input for validity
            while (!validInput) {
                System.out.print("Choose a fighter (Input: 1-" + party.getParty().size() + "):");
                String zwischenSpeicher= sc.next();
                if (isNumeric(zwischenSpeicher)) {
                    inputNumber=Integer.parseInt(zwischenSpeicher);
                    if (inputNumber > 0 && inputNumber <= party.getParty().size()) {
                        System.out.println("You have chosen " + party.getParty().get(inputNumber - 1).getName() + "!");
                        return (party.getParty().get(inputNumber - 1));
                    }
                }else{
                    System.out.println("Input not accepted. Only NUMERIC values!!");
                }


            }
        } else {
            // if only one Character, Character is automatically chosen
            System.out.println("Only one player left!");
            System.out.println(party.getParty().get(0).getName() + " (Type: " + getType(party.getParty().get(0)) + ")");
            showStats(party.getParty().get(0));
            System.out.println(party.getParty().get(0).getName() + " will fight till the end!");
            return party.getParty().get(0);
        }
        return null;
    }

    // two characters fighting until one dead (loop); dead character are killed and sent to graveyard; graveyard is shown
    public void fight(Character character, Character character2, Graveyard graveyard, Party partyOne, Party partyTwo) {
        System.out.println(getType(character) + " " + character.getName() + " of Party 1 and " + getType(character2) + " " + character2.getName() + " of Party 2 are fighting!");
        System.out.println("");
        while (character.isAlive && character2.isAlive) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            character.attack(character2);
            character2.attack(character);
            System.out.println("");
        }
        if (!character.isAlive) {
            partyOne.remove(character);
            graveyard.died(character);
        }
        if (!character2.isAlive) {
            partyTwo.remove(character2);
            graveyard.died(character2);
        }
        System.out.println("");
        System.out.println(graveyard.seeCasualties());
    }

    // return if a character is of type wizard or warrior
    public String getType(Character character) {
        if (character instanceof Wizard) {
            return "Wizard";
        } else {
            return "Warrior";
        }
    }

    // check if given value is a number
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public void showTitle(String title){
        //show title in cool format
        final int TITLEWIDTH=61; //default length of 61
        int titleLength= title.length();
        String middlePart= new String();

        int repeat1= (int) (TITLEWIDTH-titleLength)/2;
        int repeat2= (TITLEWIDTH-titleLength)-repeat1;
        System.out.println("#############################################################");
        System.out.println("#".repeat(repeat1) + title + "#".repeat(repeat2));
        System.out.println("#############################################################");
    }

    public void showStats(Character character){
        if (character instanceof Warrior) {
            System.out.println("HP:" + character.getHp() + "|Stamina:" +
                    ((Warrior) character).getStamina() + "|Strength:" +
                    ((Warrior) character).getStrength());
        } else {
            System.out.println("HP:" + character.getHp() + "|Mana:" +
                    ((Wizard) character).getMana() + "|Intelligence:" +
                    ((Wizard) character).getIntelligence());
        }
    }

    public String getValidatedUserInput(String[] validInput, String inputField, String outputInvalid){
        // check User input for validity
        Scanner sc = new Scanner(System.in);
        String userInput = null;
        boolean validationCheck= false;

        while (!validationCheck) {
            System.out.print(inputField);
            userInput=sc.next().toUpperCase();
            for(int h=0;h<validInput.length;h++){
                if(validInput[h].toUpperCase().contains(userInput)) {
                    validationCheck=true;
                    break;
                }
            }
            if(!validationCheck){System.out.println(outputInvalid);};
        }

        return userInput;
    }

}

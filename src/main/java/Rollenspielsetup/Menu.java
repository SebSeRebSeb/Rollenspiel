package Rollenspielsetup;

import java.util.Random;
import java.util.Scanner;

public class Menu {
    final int MAX_GROUPSIZE=10;
    final int SLEEPTIMER=3000;

    // game interface
    public void startMenu(Party partyOne, Party partyTwo, Graveyard graveyard) {
        String userInput;

        System.out.println();
        showTitle("DKB-RPG-SIMULATOR II");
        System.out.println();
        showTitle("Start-Menu");
        System.out.println();
        // check how parties should be created and filled with Characters (manually, from imported csv file or randomly)
        System.out.println("Press the specified key (C,L or R) to choose the parties");
        System.out.println();
        System.out.println("1) Create new parties (C)");
        System.out.println("2) Import parties (L)");
        System.out.println("3) Random fight (R)");
        // check User input for validity
        userInput = getValidatedUserInput(new String[]{"C", "L", "R"}, "User-Input: ",
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
        System.out.println();
        showTitle("!!The game starts!!");
        System.out.println();
        // choose characters
        while (!partyOne.getParty().isEmpty() && !partyTwo.getParty().isEmpty()) {
            System.out.println();
            showTitle("Party One");
            System.out.println();
            Character char1 = chooseCharacter(partyOne);
            System.out.println();
            showTitle("Party Two");
            System.out.println();
            Character char2 = chooseCharacter(partyTwo);
            System.out.println();
            showTitle("!!The fight starts!!");
            System.out.println();
            // let characters fight
            fight(char1, char2, graveyard, partyOne, partyTwo);
        }
        System.out.println();
        showTitle("The game is over!");
        System.out.println();
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
        int groupSize;
        String userInput;

        System.out.println();
        showTitle("Create new parties");
        System.out.println();
        System.out.println("Choose the size of the parties (1-"+MAX_GROUPSIZE+")");
        String[] validInput = createStringNumbers(1, MAX_GROUPSIZE);
        userInput = getValidatedUserInput(validInput, "User-Input: ",
                "Input not accepted. Only NUMERIC values between 1 and 10 are accepted.");
        groupSize = Integer.parseInt(userInput);
        System.out.println();
        showTitle("Party One");
        System.out.println();
        for (int i = 0; i < groupSize; i++) {
            System.out.println("##################Create " + (i + 1) + ". Character##############");
            addCharactertoParty(partyOne);
        }
        System.out.println();
        showTitle("Party Two");
        System.out.println();
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
        String userInput;

        userInput = getValidatedUserInput(new String[]{"J", "N"}, "Do you wish to export the created parties (J/N)?: ",
                "Input not accepted. Please choose between J and N.");
        if (userInput.equals("J")) {
            partyOne.exportParty("partyOne.csv");
            partyTwo.exportParty("partyTwo.csv");
            System.out.println("Party One has been successfully exported!");
            System.out.println("Party Two has been successfully exported!");
        }
    }


    // generate a party of certain size (user input) and fill in with random Characters (Wizards, Warriors)
    public void randomParties(Party partyOne, Party partyTwo) {
        Random random = new Random();
        int iteration = random.nextInt(MAX_GROUPSIZE+1);
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
            randomNumber = random.nextInt(2);
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
        String userInput;

        //Input for type of character
        userInput = getValidatedUserInput(new String[]{"1", "2"}, "Type of character (1=Wizard;2=Warrior): ",
                "Input not accepted. Choose between Wizard(1) and Warrior(2)");
        switch (userInput) {
            case "1":
                Wizard wizard = new Wizard();
                party.add(wizard);
                System.out.println("Wizard " + wizard.getName() + " was created!");
                break;
            case "2":
                Warrior warrior = new Warrior();
                party.add(warrior);
                System.out.println("Warrior " + warrior.getName() + " was created!");
                break;
        }
    }

    // choose character via user input to let the fight against each other
    public Character chooseCharacter(Party party) {
        int inputNumber;
        int partySize = party.getParty().size();
        String userInput;
        Character character;

        if (partySize > 1) {
            //show remaining characters
            System.out.println("Choose your fighter:");
            for (int i = 0; i < partySize; i++) {
                character=party.getParty().get(i);
                System.out.println((i + 1) + ". Character " + character.getName() + " (Type: " + getType(character) + ")");
                showStats(character);
            }
            //let user chose player
            // incl. check input for validity
            String[] validInput = createStringNumbers(1, partySize);
            userInput = getValidatedUserInput(validInput, "Choose a fighter (Input: 1-" + partySize + "): ",
                    "Input not accepted. Only NUMERIC values in the specified boundaries!!");
            inputNumber = Integer.parseInt(userInput);
            character=party.getParty().get(inputNumber - 1);
            System.out.println("You have chosen " + character.getName() + "!");
        } else {
            // if only one Character, Character is automatically chosen
            System.out.println("Only one player left!");
            character=party.getParty().get(0);
            System.out.println(character.getName() + " (Type: " + getType(character) + ")");
            showStats(character);
            System.out.println(character.getName() + " will fight till the end!");
        }
        return (character);
    }

    // two characters fighting until one dead (loop); dead character are killed and sent to graveyard; graveyard is shown
    public void fight(Character character, Character character2, Graveyard graveyard, Party partyOne, Party partyTwo) {
        System.out.println(getType(character) + " " + character.getName() + " of Party 1 and " + getType(character2) + " " + character2.getName() + " of Party 2 are fighting!");
        System.out.println();
        while (character.isAlive && character2.isAlive) {
            try {
                Thread.sleep(SLEEPTIMER);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            character.attack(character2);
            character2.attack(character);
            System.out.println();
        }
        if (!character.isAlive) {
            partyOne.remove(character);
            graveyard.died(character);
        }
        if (!character2.isAlive) {
            partyTwo.remove(character2);
            graveyard.died(character2);
        }
        System.out.println();
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

    public void showTitle(String title) {
        //show title in cool format
        final int TITLEWIDTH = 61; //default length of 61
        int titleLength = title.length();

        int repeat1 = ((TITLEWIDTH - titleLength) / 2);
        int repeat2 = (TITLEWIDTH - titleLength) - repeat1;
        System.out.println("#############################################################");
        System.out.println("#".repeat(repeat1) + title + "#".repeat(repeat2));
        System.out.println("#############################################################");
    }

    public void showStats(Character character) {
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

    public String getValidatedUserInput(String[] validInput, String inputField, String outputInvalid) {
        // check User input for validity
        Scanner sc = new Scanner(System.in);
        String userInput = null;
        boolean validationCheck = false;

        while (!validationCheck) {
            System.out.print(inputField);
            userInput = sc.next().toUpperCase();
            for (String s : validInput) {
                if (s.toUpperCase().equals(userInput)) {
                    validationCheck = true;
                    break;
                }
            }
            if (!validationCheck) {
                System.out.println(outputInvalid);
            }
        }

        return userInput;
    }

    public String[] createStringNumbers(int begin, int end) {
        String[] result = new String[end - begin + 1];
        for (int i = begin; i <= end; i++) {
            result[i - begin] = Integer.toString(i);
        }
        return result;
    }

}

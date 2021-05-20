package Rollenspielsetup;


import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Menu {

    public void startMenu(Party partyOne, Party partyTwo, Graveyard graveyard) {
        Scanner sc = new Scanner(System.in);
        boolean isValidInput = false;
        System.out.println("");
        System.out.println("#############################################################");
        System.out.println("###################DKB-RPG-SIMULATOR II######################");
        System.out.println("#############################################################");
        System.out.println("######################Start-Menu#############################");
        System.out.println("#############################################################");
        System.out.println("");
        System.out.println("Press the specified key (C,L or R) to choose the parties");
        System.out.println("");
        System.out.println("1) Create new parties (C)");
        System.out.println("2) Import parties (L)");
        System.out.println("3) Random fight (R)");
        while (!isValidInput) {
            System.out.print("User-Input: ");
            switch (sc.next().toUpperCase()) {
                case "C":
                    isValidInput = true;
                    System.out.println("Party will be created!");
                    createParty(partyOne, partyTwo);
                    exportParty(partyOne, partyTwo);
                    break;
                case "L":
                    isValidInput = true;
                    System.out.println("Party will be imported!");
                    importParty(partyOne, partyTwo);
                    break;
                case "R":
                    isValidInput = true;
                    System.out.println("Random mode!");
                    randomParties(partyOne, partyTwo);
                    break;
                default:
                    System.out.println("Input not accepted. Please choose between 1) (=C), 2) (=L) and 3) (=R).");
            }
        }
        System.out.println("");
        System.out.println("####################The game starts!#########################");
        System.out.println("");

        while (!partyOne.getParty().isEmpty() && !partyTwo.getParty().isEmpty()) {
            System.out.println("#############################################################");
            System.out.println("######################Party One##############################");
            System.out.println("#############################################################");
            System.out.println("");
            Character char1 = chooseCharacter(partyOne);
            System.out.println("");
            System.out.println("#############################################################");
            System.out.println("######################Party Two##############################");
            System.out.println("#############################################################");
            System.out.println("");
            Character char2 = chooseCharacter(partyTwo);
            System.out.println("");
            System.out.println("#############################################################");
            System.out.println("###################The fight starts!#########################");
            System.out.println("#############################################################");
            System.out.println("");

            fight(char1, char2, graveyard, partyOne, partyTwo);
        }
        System.out.println("");
        System.out.println("#############################################################");
        System.out.println("###################The Game is over!#########################");
        System.out.println("#############################################################");
        System.out.println("");

        if (partyTwo.getParty().isEmpty() && partyOne.getParty().isEmpty()) {
            System.out.println("#############################################################");
            System.out.println("###################It's a TIE !##############################");
            System.out.println("#############################################################");
        } else if (partyTwo.getParty().isEmpty()) {
            System.out.println("#############################################################");
            System.out.println("###################Party 1 won!##############################");
            System.out.println("#############################################################");
        } else if (partyOne.getParty().isEmpty()) {
            System.out.println("#############################################################");
            System.out.println("###################Party 2 won!##############################");
            System.out.println("#############################################################");
        }

    }

    public void createParty(Party partyOne, Party partyTwo) {
        Scanner sc = new Scanner(System.in);
        Integer groupSize;
        String userInput = "";
        boolean isValidInput = false;

        System.out.println("");
        System.out.println("#############################################################");
        System.out.println("##################Create new parties#########################");
        System.out.println("#############################################################");
        System.out.println("");
        System.out.println("Choose the size of the parties (1-10)");
        while (!isValidInput) {
            System.out.print("User-Input: ");
            userInput = sc.next();
            if (isNumeric(userInput)) {
                groupSize = Integer.parseInt(userInput);
                if ((groupSize <= 10) && (groupSize > 0)) {
                    isValidInput = true;
                    System.out.println("");
                    System.out.println("#############################################################");
                    System.out.println("######################Party One##############################");
                    System.out.println("#############################################################");
                    System.out.println("");
                    for (int i = 0; i < groupSize; i++) {
                        System.out.println("##################Create " + (i + 1) + ". Character##############");
                        addCharactertoParty(partyOne);
                    }
                    System.out.println("");
                    System.out.println("#############################################################");
                    System.out.println("######################Party Two##############################");
                    System.out.println("#############################################################");
                    System.out.println("");
                    for (int i = 0; i < groupSize; i++) {
                        System.out.println("##################Create " + (i + 1) + ". Character##############");
                        addCharactertoParty(partyTwo);
                    }
                } else {
                    System.out.println("Input not accepted. Only values between 1 and 10 are accepted.");
                }
            } else {
                System.out.println("Input not accepted. Only NUMERIC values between 1 and 10 are accepted.");
            }
        }
    }

    public void importParty(Party partyOne, Party partyTwo) {
        partyOne.importParty("partyOne.csv");
        System.out.println("Party One has been successfully imported!");
        partyTwo.importParty("partyTwo.csv");
        System.out.println("Party Two has been successfully imported!");
    }

    public void exportParty(Party partyOne, Party partyTwo) {
        Scanner sc = new Scanner(System.in);
        boolean isValidInput = false;

        while (!isValidInput) {
            System.out.print("Do you wish to export the created parties (J/N)?: ");
            switch (sc.next().toUpperCase()) {
                case "J":
                    //System.out.println(partyOne.exportParty("test1")) ;
                    //System.out.println(partyTwo.exportParty("test2"));
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

    public Character chooseCharacter(Party party) {
        Scanner sc = new Scanner(System.in);
        Integer inputNumber;

        boolean validInput = false;

        if (party.getParty().size() > 1) {
            System.out.println("Choose your fighter:");
            for (int i = 0; i < party.getParty().size(); i++) {
                System.out.println((i + 1) + ". Character " + party.getParty().get(i).getName() + " (Type: " + getType(party.getParty().get(i)) + ")");
                if (party.getParty().get(i) instanceof Warrior) {
                    System.out.println("HP:" + party.getParty().get(i).getHp() + "|Stamina:" +
                            ((Warrior) party.getParty().get(i)).getStamina() + "|Strength:" +
                            ((Warrior) party.getParty().get(i)).getStrength());
                } else {
                    System.out.println("HP:" + party.getParty().get(i).getHp() + "|Mana:" +
                            ((Wizard) party.getParty().get(i)).getMana() + "|Intelligence:" +
                            ((Wizard) party.getParty().get(i)).getIntelligence());
                }
            }
            while (!validInput) {
                System.out.print("Choose a fighter (Input: 1-" + party.getParty().size() + "):");
                inputNumber = Integer.parseInt(sc.next());
                if(inputNumber > 0 && inputNumber <= party.getParty().size()){
                System.out.println("You have chosen " + party.getParty().get(inputNumber - 1).getName() + "!");
                validInput = true;
                return (party.getParty().get(inputNumber - 1));}
            }
        } else {
            System.out.println("Only one player left!");
            System.out.println(party.getParty().get(0).getName() + " (Type: " + getType(party.getParty().get(0)) + ")");
            System.out.println("HP:" + party.getParty().get(0).getHp() + "|Mana:" +
                    ((Wizard) party.getParty().get(0)).getMana() + "|Intelligence:" +
                    ((Wizard) party.getParty().get(0)).getIntelligence());
            System.out.println(party.getParty().get(0).getName() + " will fight till the end!");
            return party.getParty().get(0);
        }
        return null;
    }


    public void fight(Character character, Character character2, Graveyard graveyard, Party partyOne, Party partyTwo) {
        System.out.println(getType(character) + " " + character.getName() + " of Party 1 and " + getType(character2) + " " + character2.getName() + " of Party 2 are fighting!");
        System.out.println("");
        while (character.isAlive && character2.isAlive) {
            character.attack(character2);
            character2.attack(character);
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


    public String getType(Character character) {
        if (character instanceof Wizard) {
            return "Wizard";
        } else {
            return "Warrior";
        }
    }


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
}

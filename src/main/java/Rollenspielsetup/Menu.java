package Rollenspielsetup;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    public void startMenu(ArrayList<Character> partyOne, ArrayList<Character> partyTwo){
        Scanner sc = new Scanner(System.in);
        boolean isValidInput=false;

        System.out.println("#############################################################");
        System.out.println("###################DKB-RPG-SIMULATOR II######################");
        System.out.println("#############################################################");
        System.out.println("######################Start-Menu#############################");
        System.out.println("#############################################################");
        System.out.println("");
        System.out.println("Press the specified key (C or L) to choose the parties");
        System.out.println("");
        System.out.println("1) Create new parties (C)");
        System.out.println("2) Import parties (L)");
        while(!isValidInput) {
            System.out.print("User-Input: ");
            switch (sc.next()) {
                case "C":
                    isValidInput=true;
                    System.out.println("Party will be created!");
                    createParty(partyOne, partyTwo);
                    break;
                case "L":
                    isValidInput=true;
                    System.out.println("Party will be imported!");
                    break;
                default:
                    System.out.println("Input not accepted. Please choose between 1) (=C) and 2) (=L).");
            }
        }
        System.out.println("The Game will be started!");
        System.out.println("#############################################################");
        System.out.println("######################Party One##############################");
        System.out.println("#############################################################");
        System.out.println("");
        System.out.println("You have chosen "+chooseCharacter(partyOne).getName() +"!");
        System.out.println("");
        System.out.println("#############################################################");
        System.out.println("######################Party Two##############################");
        System.out.println("#############################################################");
        System.out.println("");
        System.out.println("You have chosen "+chooseCharacter(partyTwo).getName() +"!");
        System.out.println("");
        System.out.println("#############################################################");
        System.out.println("###################The fight starts!#########################");
        System.out.println("#############################################################");
        System.out.println("");
    }

    public void createParty(ArrayList<Character> partyOne, ArrayList<Character> partyTwo){
        Scanner sc = new Scanner(System.in);
        Integer groupSize;
        String userInput = "";
        boolean isValidInput=false;


        System.out.println("#############################################################");
        System.out.println("##################Create new parties#########################");
        System.out.println("#############################################################");
        System.out.println("");
        System.out.println("Choose the size of the parties (1-10)");
        while(!isValidInput){
            System.out.print("User-Input: ");
            userInput = sc.next();
            if(isNumeric(userInput)) {
                groupSize = Integer.parseInt(userInput);
                if((groupSize<=10)&&(groupSize>0)){
                    isValidInput=true;
                    System.out.println("#############################################################");
                    System.out.println("######################Party One##############################");
                    System.out.println("#############################################################");
                    System.out.println("");
                    for (int i = 0; i < groupSize; i++) {
                        System.out.println("##################Create "+(i+1)+". Character##############");
                        addCharactertoParty(partyOne);
                    }
                    System.out.println("#############################################################");
                    System.out.println("######################Party Two##############################");
                    System.out.println("#############################################################");
                    System.out.println("");
                    for (int i = 0; i < groupSize; i++) {
                        System.out.println("##################Create "+(i+1)+". Character##############");
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

    public void addCharactertoParty(ArrayList<Character> party){
        Scanner sc = new Scanner(System.in);
        String inputType;
        String name;

        //Input for type of character
        System.out.print("Typ of character (1=Wizard;2=Warrior): ");
        inputType=sc.next();
        System.out.print("Name of character: ");
        name=sc.next();
        switch(inputType){
            case "1":
                Wizard wizard= new Wizard(name);
                party.add(wizard);
                System.out.println("Wizard "+ name + " was created!");
                break;
            case "2":
                Warrior warrior= new Warrior(name, 12, 12, 12);
                party.add(warrior);
                System.out.println("Warrior "+ name + " was created!");
                break;
            default:
                System.out.println("Input not accepted. Choose between Wizard(1) and Warrior(2)");
        }
    }

    public Character chooseCharacter(ArrayList<Character> party){
        Scanner sc = new Scanner(System.in);
        Integer inputNumber;
        System.out.println("Choose your fighter:");
        for(int i=0;i<party.size();i++){
            System.out.println((i+1)+". Character " + party.get(i).getName() + " (Type: "+ getType(party.get(i))+")");
        }
        System.out.print("Choose a fighter (Input: 1-"+party.size()+"):");
        inputNumber=Integer.parseInt(sc.next());
        return(party.get(inputNumber-1));
    }

    public String getType(Character character){
        if(character instanceof Wizard){
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
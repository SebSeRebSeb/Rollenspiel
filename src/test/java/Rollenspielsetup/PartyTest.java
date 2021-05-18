package Rollenspielsetup;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PartyTest {

    public Party party1 = new Party();
    public Party party2 = new Party();
    public Wizard wizard1;
    public Wizard wizard2;
    public Wizard wizard3;
    public Wizard wizard4;
    public Warrior warrior1;
    public Warrior warrior2;
    public Warrior warrior3;
    public Warrior warrior4;

    public Party graveyard;

    @Test
    @BeforeEach
    public void init(){
        //initialize warriors
        warrior1= new Warrior("Frank",120,12,9);
        warrior2= new Warrior("Peter");
        warrior3= new Warrior("Paul",150,45,5);
        warrior4= new Warrior("Karl");
        //initialize wizards
        wizard1= new Wizard("Ned",65,12,12);
        wizard2= new Wizard("Ted");
        wizard3= new Wizard("Fred",75,45,50);
        wizard4= new Wizard("Otto");
        //initialize party1
        party1.add(warrior1);
        party1.add(warrior2);
        party1.add(wizard1);
        party1.add(wizard2);
        //initialize party2
        party2.add(warrior3);
        party2.add(warrior4);
        party2.add(wizard3);
        party2.add(wizard4);

    }

    @Test
    void getParty() {

    }

    @Test
    void setParty() {
    }
}
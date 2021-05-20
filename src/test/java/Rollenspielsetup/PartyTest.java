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
        warrior2= new Warrior();
        warrior3= new Warrior("Paul",150,45,5);
        warrior4= new Warrior();
        //initialize wizards
        wizard1= new Wizard("Ned",65,12,12);
        wizard2= new Wizard();
        wizard3= new Wizard("Fred",75,45,50);
        wizard4= new Wizard();

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
    void testGetParty() {
        ArrayList<Character> arrList = new ArrayList();
        arrList.add(warrior1);
        arrList.add(warrior2);
        arrList.add(wizard1);
        arrList.add(wizard2);
        assertEquals(arrList,party1.getParty());
        assertNotEquals(arrList,party2.getParty());
    }

    @Test
    void testSetParty() {
        Party party3 = new Party();
        party3.setParty(party2.getParty());

        assertEquals(150,party3.getParty().get(0).hp);
        assertEquals(75,party3.getParty().get(2).hp);
    }

    @Test
    void testAdd(){
        Warrior warriorNeu = new Warrior();
        Wizard wizardNeu= new Wizard();

        party1.add(warriorNeu);
        party2.add(wizardNeu);

        int party1Length=party1.getParty().size()-1;
        assertEquals(warriorNeu,party1.getParty().get(party1Length));
        int party2Length=party2.getParty().size()-1;
        assertEquals(wizardNeu,party2.getParty().get(party1Length));
    }

    @Test
    void testRemove(){
        party1.remove(warrior1);
        party1.remove(wizard1);

        assertEquals(2,party1.getParty().size());

        //warrior 4 not party of party1
        party1.remove(warrior4);
        assertEquals(2,party1.getParty().size());
    }

    @Test
    void testImport(){
        Party party3 = new Party();
        warrior1= new Warrior("Frank",120,12,9);
        warrior2= new Warrior();
        wizard1= new Wizard("Paul",90,45,5);
        wizard2= new Wizard();

//        System.out.println(warrior1.getId());
//        System.out.println(warrior2.getId());
//        System.out.println(wizard1.getId());
//        System.out.println(wizard2.getId());

        String inputString = "e92c8026-4766-4be1-8b4e-bc3d0f073c27;Frank;120;12;9;Warrior\n"+
                             "e924e2f6-04a0-4bd7-9a7b-dcec508dee81;Peter;130;30;7;Warrior\n"+
                             "f0c2340f-aad0-495a-baaa-4fc19a30d797;Paul;50;45;6;Wizard\n"+
                             "3e57a942-841e-4e0a-a1cf-d7df7ce5d6e1;Karl;60;50;10;Wizard\n";


        party3.importParty(inputString);

        //Test Character 1
        assertEquals("e92c8026-4766-4be1-8b4e-bc3d0f073c27", party3.getParty().get(0).getId());
        assertEquals("Frank", party3.getParty().get(0).getName());
        assertTrue(party3.getParty().get(0) instanceof Warrior);
        //Test Character 3
        assertEquals("f0c2340f-aad0-495a-baaa-4fc19a30d797", party3.getParty().get(2).getId());
        assertEquals("Paul", party3.getParty().get(2).getName());
        assertTrue(party3.getParty().get(2) instanceof Wizard);
    }

    @Test
    void testimportexport(){
        Party party3 = new Party();

        String inputString = "e92c8026-4766-4be1-8b4e-bc3d0f073c27;Frank;120;12;9;Warrior\n"+
                "e924e2f6-04a0-4bd7-9a7b-dcec508dee81;Peter;130;30;7;Warrior\n"+
                "f0c2340f-aad0-495a-baaa-4fc19a30d797;Paul;50;45;6;Wizard\n"+
                "3e57a942-841e-4e0a-a1cf-d7df7ce5d6e1;Karl;60;50;10;Wizard\n";

        party3.importParty(inputString);
        assertEquals(inputString,party3.exportParty("test"));
    }

}
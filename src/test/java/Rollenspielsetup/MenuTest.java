package Rollenspielsetup;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MenuTest {

    Character character;
    Character character2;
    Party partyOne;
    Party partyTwo;
    Graveyard graveyard;
    Menu menu;

    @BeforeEach
    void setup(){
        partyOne = new Party();
        partyTwo = new Party();
        character = new Warrior();
        character2 = new Wizard();
        graveyard = new Graveyard();
        menu = new Menu();
    }

//    @Test
//    @DisplayName("Check if party is not empty after Character been added.")
//    void characterAdded(){
//        menu.addCharactertoParty(partyOne);
//        assertFalse(partyOne.getParty().isEmpty());
//    }
//  Müsste refactored werden!

    @Test
    @DisplayName("One or both Characters dead after fight.")
    void deadAfterFight() {
        assertTrue(character.isAlive && character2.isAlive);
        menu.fight(character, character2, graveyard, partyOne, partyTwo);
        assertFalse(character.isAlive && character2.isAlive);
    }

    @Test
    @DisplayName("Get the right Type of Character.")
    void getType(){
        assertEquals("Warrior", menu.getType(character));
        assertEquals("Wizard", menu.getType(character2));
    }


}
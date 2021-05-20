package Rollenspielsetup;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraveyardTest {
    Character testWarrior = new Warrior();

    Graveyard testGraveyard = new Graveyard();

    @Test
    void checkDied(){
        testGraveyard.died(testWarrior);
        assertSame(testWarrior,testWarrior);
    }

}
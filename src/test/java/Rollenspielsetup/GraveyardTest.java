package Rollenspielsetup;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraveyardTest {

    Character testWarrior;
    Graveyard testGraveyard;

    @BeforeEach
    void setup(){
        testWarrior = new Warrior();
        testGraveyard = new Graveyard();
    }


    @Test
    void checkDied(){
        testGraveyard.died(testWarrior);
        assertSame(testWarrior,testWarrior);
    }

}
import Rollenspielsetup.Warrior;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WarriorTest {
    Warrior testWarrior = new Warrior("Frank", 12, 12, 12);
    Warrior testWarrior2 = new Warrior("Steven");

    @Test
    @DisplayName("Hp Test")
    void checkhp() {
        assertFalse(12 == testWarrior.getHp());
    }

    @Test
    @DisplayName("Stamina Test")
    void checkStamina() {
        assertEquals(12, testWarrior.getStamina());
    }

    @Test
    @DisplayName("Warrior login only name")
    void checkName(){
        assertEquals("Steven", testWarrior2.getName());
    }
}
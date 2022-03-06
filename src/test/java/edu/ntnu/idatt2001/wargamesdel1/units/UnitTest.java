package edu.ntnu.idatt2001.wargamesdel1.units;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnitTest {

    InfantryUnit unit1;
    InfantryUnit unit2;

    @BeforeEach
    void setUp() {
        unit1 = new InfantryUnit("test", 100);
        unit2 = new InfantryUnit("test2", 100);
    }

    @Test
    void attack(){
        unit1.attack(unit2);
        assertTrue(unit1.getHealth() > unit2.getHealth());
        assertEquals(unit2.getHealth(), 100 - Math.max(unit1.getAttack() + unit1.getAttackBonus()
                - (unit2.getArmor() + unit2.getResistBonus()), 0));
    }
}
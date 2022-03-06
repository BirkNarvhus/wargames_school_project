package edu.ntnu.idatt2001.wargamesdel1.units;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CavalryUnitTest {
    CavalryUnit testCav;

    @BeforeEach
    void setUp() {
        testCav = new CavalryUnit("test", 100);
    }

    @Test
    void getAttackBonus() {
        assertEquals(4, testCav.getAttackBonus());
        assertEquals(2, testCav.getAttackBonus());
    }
}
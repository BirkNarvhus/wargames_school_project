package edu.ntnu.idatt2001.wargamesdel1.units;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CavalryUnitTest {
    ComanderUnit testCom;

    @BeforeEach
    void setUp() {
        testCom = new ComanderUnit("test", 100);
    }

    @Test
    void getAttackBonus() {
        assertEquals(4, testCom.getAttackBonus());
        assertEquals(2, testCom.getAttackBonus());
    }
}
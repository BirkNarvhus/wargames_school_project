package edu.ntnu.idatt2001.wargamesdel1.units;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.w3c.dom.ranges.Range;

import static org.junit.jupiter.api.Assertions.*;

class RangedUnitTest {

    RangedUnit testRanged;

    @BeforeEach
    void setUp() {
        testRanged = new RangedUnit("test", 100);
    }

    @Test
    void getResistBonus() {
        assertEquals(6, testRanged.getResistBonus());
        assertEquals(4, testRanged.getResistBonus());
        assertEquals(2, testRanged.getResistBonus());
        assertEquals(2, testRanged.getResistBonus());
    }
}
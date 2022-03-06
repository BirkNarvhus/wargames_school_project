package edu.ntnu.idatt2001.wargamesdel1.army;

import edu.ntnu.idatt2001.wargamesdel1.units.InfantryUnit;
import edu.ntnu.idatt2001.wargamesdel1.units.Unit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ArmyTest {
    Army testArmy;
    ArrayList<Unit> testUnits;
    @BeforeEach
    void setUp() {
        testArmy = new Army("army1");
        testUnits = new ArrayList<Unit>();

        int len = (int)(Math.random()*200 + 200);
        for (int i = 0; i < len; i++) {
            testUnits.add(new InfantryUnit("testinf", 100));
        }

        testArmy.addAll(testUnits);
    }

    @Test
    void addUnit() {
        ArrayList<Unit> testUnits2 = new ArrayList<Unit>();
        int len = (int)(Math.random()*200 + 200);
        for (int i = 0; i < len; i++) {
            testUnits2.add(new InfantryUnit("testinf", 100));
        }

        testArmy.addAll(testUnits2);
        assertEquals(testUnits2.size(), len);
    }

    @Test
    void remove() {
        int preRemove = testArmy.getAllUnits().size();

        Unit randomUnit = testArmy.getRandomUnit();
        testArmy.remove(testArmy.getRandomUnit());

        assertNotEquals(preRemove, testArmy.getAllUnits().size());
    }

    @Test
    void getRandomUnit() {
        Unit ranUnit = testArmy.getRandomUnit();
        ranUnit.setHealth(99);
        ranUnit = testArmy.getRandomUnit();
        assertNotEquals(ranUnit.getHealth(), 99);
    }

}
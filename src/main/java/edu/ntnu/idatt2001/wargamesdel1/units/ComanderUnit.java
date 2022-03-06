package edu.ntnu.idatt2001.wargamesdel1.units;

/**
 * Comander unit subclass of CavalryUnit
 * same as CavalryUnit, but different attack and armor
 * @see Unit
 *
 * @author birk
 * @version 1.01 06.03.2022
 */
public class ComanderUnit extends CavalryUnit{
    private final static int attack = 25;
    private final static int armor = 15;

    /**
     * constructor to assigne values when creation
     * uses the protected constructor in CavalryUnit
     *
     * @param name   type string
     * @param health type String
     * @throws IllegalArgumentException if name is empty or health is less then or equals 0
     */
    public ComanderUnit(String name, int health) throws IllegalArgumentException {
        super(name, health, attack, armor);
    }

    /**
     * overload constructer for deep copying another unit
     * @param unit unit to clone
     */
    public ComanderUnit(Unit unit){
        super(unit);
    }
}

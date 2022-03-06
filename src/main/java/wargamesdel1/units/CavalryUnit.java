package wargamesdel1.units;

import java.util.ArrayList;

/**
 * Cavalry unit
 * gets bonus in attack, and small bonus in resistance
 * subclass to Units super class
 * @see Unit
 *
 * @author birk
 * @version 1.01 06.03.2022
 */
public class CavalryUnit extends Unit{

    // local static default variabels
    // for easy change, but they shoud not be changed when game is running
    // static so they can be used before super class constructer
    static int attackBonus = 4;
    static int resistBonus = 1;
    static int attack = 20;
    static int armor = 12;


    //changes when getBonusAttack is called
    private boolean charged = false;

    /**
     * constructor to assigne values when creation
     * @param name type string
     * @param health type
     * @throws IllegalArgumentException if name is empty or health is less then or equals 0
     */
    public CavalryUnit(String name, int health) throws IllegalArgumentException {
        super(name, health, attack, armor);
    }

    /**
     * constructor to assigne values when creation
     * this is protected and is only inteded to be used in child classes where the attack and defennce
     * differ
     * @param name type string
     * @param health type string
     * @param attack type int
     * @param armor type int
     * @throws IllegalArgumentException if name is empty or health is less then or equals 0
     */
    protected CavalryUnit(String name, int health, int attack, int armor) throws IllegalArgumentException {
        super(name, health, attack, armor);
    }

    /**
     * overload constructer for deep copying another unit
     * @param unit unit to clone
     */
    public CavalryUnit(Unit unit){
        super(unit);
    }

    /**
     * retunrs the default attack bonus
     * @return attack bonus type int
     */
    @Override
    public int getAttackBonus() {
        int temp_attack = charged ? attackBonus - 2 : attackBonus;
        charged = true;
        return temp_attack;
    }

    /**
     * retunrs the default resist bonus
     * @return resist bonus type int
     */
    @Override
    public int getResistBonus() {
        return resistBonus;
    }
}

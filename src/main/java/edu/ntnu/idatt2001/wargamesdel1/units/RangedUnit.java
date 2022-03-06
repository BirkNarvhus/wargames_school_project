package edu.ntnu.idatt2001.wargamesdel1.units;

/**
 * RangedUnit
 * gets bonus in attack cous it can attack from rang
 * subclass to Units super class
 * @see Unit
 *
 * @author birk
 * @version 1.01 06.03.2022
 */
public class RangedUnit extends Unit{

    // local static default variabels
    // for easy change, but they shoud not be changed when game is running
    // static so they can be used before super class constructer
    private final static int attackBonus = 3;
    private final static int resistBonus = 2;
    private final static int attack = 15;
    private final static int armor = 8;


    //changes when get bonus resist is calle
    private int bonusResistCounter = 2;

    /**
     * constructor to assigne values when creation
     * @param name type string
     * @param health type
     * @throws IllegalArgumentException if name is empty or health is less then or equals 0
     */
    public RangedUnit(String name, int health) throws IllegalArgumentException {
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
    protected RangedUnit(String name, int health, int attack, int armor) throws IllegalArgumentException {
        super(name, health, attack, armor);
    }

    /**
     * overload constructer for deep copying another unit
     * @param unit unit to clone
     */
    public RangedUnit(Unit unit){
        super(unit);
    }

    /**
     * retunrs the default attack bonus
     * @return attack bonus type int
     */
    @Override
    public int getAttackBonus() {
        return attackBonus;
    }

    /**
     * retunrs the default resist bonus
     * it gets a bonus thed first 2 times the memthod is called
     * from bonus resist counter
     * @return resist bonus type int
     */
    @Override
    public int getResistBonus() {
        if (bonusResistCounter > 0) {
            int temp_resist = resistBonus + bonusResistCounter * 2;
            bonusResistCounter -= 1;
            return temp_resist;
        }
        return resistBonus;
    }
}

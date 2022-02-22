package wargamesdel1.units;

/**
 * Infantry unit
 * gets bonus in attack, and small bonus in resistance
 * subclass to Units super class
 * @see Unit
 *
 * @author birk
 * @version 1.01 22.02.2022
 */
public class InfantryUnit extends Unit{

    // local static default variabels
    // for easy change, but they shoud not be changed when game is running
    // static so they can be used before super class constructer
    static int attackBonus = 2;
    static int resistBonus = 1;
    static int attack = 15;
    static int armor = 10;

    /**
     * constructor to assigne values when creation
     * @param name type string
     * @param health type
     * @throws IllegalArgumentException if name is empty or health is less then or equals 0
     */
    public InfantryUnit(String name, int health) throws IllegalArgumentException {
        super(name, health, attack, armor);
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
     * @return resist bonus type int
     */
    @Override
    public int getResistBonus() {
        return resistBonus;
    }
}

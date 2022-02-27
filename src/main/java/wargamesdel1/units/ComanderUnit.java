package wargamesdel1.units;

public class ComanderUnit extends CavalryUnit{
    static int attack = 25;
    static int armor = 15;

    /**
     * constructor to assigne values when creation
     *
     * @param name   type string
     * @param health type
     * @throws IllegalArgumentException if name is empty or health is less then or equals 0
     */

    public ComanderUnit(String name, int health) throws IllegalArgumentException {
        super(name, health);
    }
}

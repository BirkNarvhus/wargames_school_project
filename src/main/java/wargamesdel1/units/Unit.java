package wargamesdel1.units;

/**
 * abstact class for super too different sub classes
 * exp: cavalery and ranged
 *
 * @author birk
 * @version 1.01 22.02.2022
 */
public abstract class Unit {
    private String name;
    private int health;
    private int attack;
    private int armor;

    /**
     * konstructer for assaigning values when super() is used
     * @param name  the name of the unit, type string
     * @param health the health of the unit, type intcc
     * @param attack the attack of the unit, type intcc
     * @param armor the armor of the unit, type intcc
     * @throws IllegalArgumentException  when any value is below 0 and if health is 0 on construction
     * or unit has no name
     */
    protected Unit(String name, int health, int attack, int armor) throws IllegalArgumentException{
        if (health <= 0 || attack < 0 || armor < 0 || name.isEmpty())
            throw new IllegalArgumentException("input values where outside expected range");
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.armor = armor;
    }

    /**
     * method to change the health stat of the opponent when its attacked
     * uses the getAttackBonus, and getResistBonus abstact methods
     * deals at minimum 0 damage so they cant regain health
     * @param opponent opponent to inflic damage to, type Unit
     */
    public void attack(Unit opponent){
        opponent.setHealth(opponent.getHealth() - Math.max(this.getAttack() + getAttackBonus()
                - (opponent.getArmor() + opponent.getResistBonus()), 0));
    }

    /**
     * sets the health variabel
     * @param health the new health
     */
    public void setHealth(int health){
        this.health = health;
    };


    /**
     * @return attack bonus int defined in sub classes
     */
    public abstract int getAttackBonus();

    /**
     * @return resist bonus int defined in sub classes
     */
    public abstract int getResistBonus();

    /**
     * gives the name
     * @return name type string
     */
    public String getName() {
        return name;
    }

    /**
     * gives the health
     * @return health type int
     */
    public int getHealth() {
        return health;
    }

    /**
     * gives the attack
     * @return attack type int
     */
    public int getAttack() {
        return attack;
    }

    /**
     * gives the armor
     * @return armor type int
     */
    public int getArmor() {
        return armor;
    }

    /**
     * defuault to string for subclasses
     * @return string value
     */
    @Override
    public String toString() {
        return "Unit{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", attack=" + attack +
                ", armor=" + armor +
                '}';
    }
}

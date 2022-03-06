package wargamesdel1.units;

import java.util.Objects;

/**
 * abstact class for super too different sub classes
 * exp: cavalery and ranged
 *
 * @author birk
 * @version 1.01 06.03.2022
 */
public abstract class Unit {
    final private String name;
    private int health;
    final private int attack;
    final private int armor;

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
     * overload constructer for deep copying another unit
     * @param unit unit to clone
     */
    public Unit(Unit unit){
        this.name = unit.getName();
        this.health = unit.getHealth();
        this.attack = unit.getAttack();
        this.armor = unit.getArmor();
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
     * checks if two objcts equal
     * used in .contais, and used when removing object from arraylsit in army class
     * @see wargamesdel1.army.Army
     * @param o object to check
     * @return if object is equal to check object
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Unit unit)) return false;
        return getHealth() == unit.getHealth() && getAttack() == unit.getAttack() && getArmor() == unit.getArmor() && getName().equals(unit.getName()) && unit.getClass() == getClass();
    }

    /**
     * overide to ensure equals and hashcode gives same otucome
     * @return hascode
     */
    @Override
    public int hashCode() {
        return Objects.hash(getName(), getHealth(), getAttack(), getArmor(), getClass());
    }

    /**
     * defuault to string for subclasses
     * @return string value
     */
    @Override
    public String toString() {
        return "[" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", attack=" + attack +
                ", armor=" + armor +
                ']';
    }
}

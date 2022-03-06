package wargamesdel1.sim;

import wargamesdel1.army.Army;
import wargamesdel1.units.Unit;

/**
 * Battle class used to sim a battle
 * stores the armies in the battle
 *
 * @author birk
 * @version 1.02 06.03.2022
 */
public class Battle {
    private final Army army1;
    private final Army army2;

    /**
     * assignes the armies
     * @param army1 first army
     * @param army2 second army
     */
    public Battle(Army army1, Army army2) {
        this.army1 = army1;
        this.army2 = army2;
    }

    /**
     * loops the simulation and returns the winning army
     * @return army that won
     */
    public Army simulate(){

        Unit unit1 = army1.getRandomUnit();
        Unit unit2 = army2.getRandomUnit();

        int counter = 0;

        while (unit1 != null && unit2 != null) {

            counter++;
            unit1.attack(unit2);
            unit2.attack(unit1);

            if (unit1.getHealth() <= 0)
                army1.remove(unit1);

            if (unit2.getHealth() <= 0)
                army2.remove(unit2);

            unit1 = army1.getRandomUnit();
            unit2 = army2.getRandomUnit();
        }

        System.out.println("counter is: " + counter);
        return (unit1 == null) ? army2 : army1;
    }

    /**
     * to string overide to see what armies are fighting
     * @return string
     */
    @Override
    public String toString() {
        return "Battle{" +
                "army1=" + army1.getName() +
                ", army2=" + army2.getName() +
                '}';
    }
}

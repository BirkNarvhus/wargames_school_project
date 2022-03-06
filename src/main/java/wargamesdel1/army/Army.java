package wargamesdel1.army;

import wargamesdel1.units.CavalryUnit;
import wargamesdel1.units.ComanderUnit;
import wargamesdel1.units.InfantryUnit;
import wargamesdel1.units.Unit;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Army class to store units
 *
 * @author birk
 * @version 1.02 06.03.2022
 */
public class Army {
    //name of army
    final private String name;

    //units in army
    final private ArrayList<Unit> units;

    /**
     * assignes name, and creates units list
     * @param name name of army type string
     */
    public Army(String name) {
        this.name = name;
        this.units = new ArrayList<Unit>();
    }

    /**
     * Overload in case you want to pass a units list when constructed
     * @param name name of army type string
     */
    public Army(String name, ArrayList<Unit> Units) {
        this.name = name;
        this.units = Units;
    }

    /**
     * returns the name of the army
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * adds unit to units list
     * deepcopys of the unit is added
     * @param unit unit to add
     * @throws IllegalArgumentException when unit class is not correct
     */
    public void addUnit(Unit unit) throws IllegalArgumentException{
        if (unit.getClass() == CavalryUnit.class)
            units.add(new CavalryUnit(unit));
        else
        if (unit.getClass() == ComanderUnit.class)
            units.add(new ComanderUnit(unit));
        else
        if (unit.getClass() == InfantryUnit.class)
            units.add(new InfantryUnit(unit));
        else
            throw new IllegalArgumentException("Unit class not handeld in army");
    }

    /**
     * lists all units in one string
     * @return string of all units
     */
    public String stringAll(){
        return units.stream().map(Unit::toString).collect(Collectors.joining("\n"));
    }
}

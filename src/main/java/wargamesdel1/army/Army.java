package wargamesdel1.army;

import wargamesdel1.units.*;

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
    private final String name;

    //units in army
    private final ArrayList<Unit> units;

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
     * copys a unit
     * used multiple times in army class to remove references
     * @param unit unit to copy
     * @return copied unit
     */
    private Unit copyUnit(Unit unit){
        if (unit.getClass() == CavalryUnit.class)
            return new CavalryUnit(unit);
        else
        if (unit.getClass() == ComanderUnit.class)
            return new ComanderUnit(unit);
        else
        if (unit.getClass() == InfantryUnit.class)
            return new InfantryUnit(unit);
        else
        if (unit.getClass() == RangedUnit.class)
            return new RangedUnit(unit);
        return null;
    }

    /**
     * adds unit to units list
     * deepcopys of the unit is added
     * @param unit unit to add
     * @throws IllegalArgumentException when unit class is not handeld
     */
    public void addUnit(Unit unit) throws IllegalArgumentException{
        Unit copiedUnit = copyUnit(unit);
        if (copiedUnit != null)
            units.add(copiedUnit);
        else
            throw new IllegalArgumentException("Unit class not handeld in army");
    }

    /**
     * loops a list and calls addUnit method on elements
     * @param units units to add
     * @throws IllegalArgumentException if unit class is not handeld
     */
    public void addAll(ArrayList<Unit> units) throws IllegalArgumentException {
        units.forEach(this::addUnit);
    }

    /**
     * removes a unit from units
     * @param unit unit to remove
     */
    public void remove(Unit unit){
        units.remove(unit);
    }

    /**
     * check if unit is in units
     * @param unit unit to check
     * @return boolean on if units is in units
     */
    public boolean hasUnit(Unit unit){
        return units.contains(unit);
    }

    /**
     * copys all units and ruturns copied list
     * @return arraylsit of all units
     */
    public ArrayList<Unit> getAllUnits(){
        return new ArrayList<Unit>(units.stream().map(this::copyUnit).toList());
    }

    /**
     * returns a random unit from units
     * this is not a deep copy, becouse we want to save changes to units list
     * @return unit null if no unit is found
     */
    public Unit getRandomUnit(){
        try {
            return units.get((int) (Math.random() * (units.size() - 1)));
        }catch (IndexOutOfBoundsException e){
            return null;
        }
    }

    /**
     * lists all units in one string
     * @return string of all units
     */
    @Override
    public String toString() {
        return getName()+": \n"+units.stream().map(Unit::toString).collect(Collectors.joining("\n"));
    }


}

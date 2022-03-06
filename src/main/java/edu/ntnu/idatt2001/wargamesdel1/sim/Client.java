package edu.ntnu.idatt2001.wargamesdel1.sim;

import edu.ntnu.idatt2001.wargamesdel1.army.Army;
import edu.ntnu.idatt2001.wargamesdel1.units.*;

/**
 * future client
 * now its used to hardcode a test case
 *
 * @author birk
 * @version 1.01 06.03.2022
 */
public class Client {
    private final Army army1;
    private final Army army2;

    //defualt hp values and names:
    private final String nameInf = "infantryUnit";
    private final int hpInf = 100;

    private final String nameCav = "cavalryUnit";
    private final int hpCav = 100;

    private final String nameRanged = "rangedUnit";
    private final int hpRanged = 100;

    private final String nameCom = "Comander";
    private final int hpCom = 180;

    /**
     * creates armies on construction of Class
     */
    public Client() {
        this.army1 = new Army("humans");
        this.army2 = new Army("not humans");
    }

    /**
     * loops the different unit types and addes them to army.
     * it also indexes the units (probobly better to do this in the army object)
     * @param army army to add units
     * @param numInf number of infantryUnits
     * @param numCav number of cavUnits
     * @param numRange number of rangedUnits
     * @param numCom number of comanderUnits
     */
    private void createArmy(Army army, int numInf, int numCav, int numRange, int numCom){

        for (int i = 0; i < numInf; i++) {
            army.addUnit(new InfantryUnit(nameInf + i, hpInf));
        }
        for (int i = 0; i < numCav; i++) {
            army.addUnit(new CavalryUnit(nameCav + i, hpCav));
        }
        for (int i = 0; i < numRange; i++) {
            army.addUnit(new RangedUnit(nameRanged + i, hpRanged));
        }
        for (int i = 0; i < numCom; i++) {
            army.addUnit(new ComanderUnit(nameCom + i, hpCom));
        }

    }


    /**
     * create battle object from army1 and army2 class variabels
     * @return battle object
     */
    public Battle createBattle(){
        createArmy(army1, 500, 100, 200, 1);
        createArmy(army2, 300, 100, 200, 1);
        return new Battle(army1, army2);
    }
}

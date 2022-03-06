package edu.ntnu.idatt2001.wargamesdel1.sim;

import edu.ntnu.idatt2001.wargamesdel1.army.Army;
import edu.ntnu.idatt2001.wargamesdel1.units.*;

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
     * @param army1 army 1
     * @param army2 army 2
     */
    public Client() {
        this.army1 = new Army("humans");
        this.army2 = new Army("not humans");
    }

    private Army createArmy(Army army, int numInf, int numCav, int numRange, int numCom){

        for (int i = 0; i < numInf; i++) {
            army.addUnit(new InfantryUnit(nameInf, hpInf));
        }
        for (int i = 0; i < numCav; i++) {
            army.addUnit(new CavalryUnit(nameCav, hpCav));
        }
        for (int i = 0; i < numRange; i++) {
            army.addUnit(new RangedUnit(nameRanged, hpRanged));
        }
        for (int i = 0; i < numCom; i++) {
            army.addUnit(new ComanderUnit(nameCom, hpCom));
        }

        return army;
    }


    /**
     * create battle object from army1 and army2 class variabels
     * @return battle object
     */
    public Battle createBattle(){
        createArmy(army1, 500, 100, 200, 1);
        createArmy(army2, 500, 100, 200, 1);
        return new Battle(army1, army2);
    }
}

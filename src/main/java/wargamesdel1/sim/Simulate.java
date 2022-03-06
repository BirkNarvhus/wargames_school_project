package wargamesdel1.sim;

import wargamesdel1.army.Army;
import wargamesdel1.units.ComanderUnit;

/**
 * runs the game/simulation
 */
public class Simulate {
    public static void main(String[] args) {

        Client client = new Client();

        System.out.println(client.createBattle().simulate());
    }
}

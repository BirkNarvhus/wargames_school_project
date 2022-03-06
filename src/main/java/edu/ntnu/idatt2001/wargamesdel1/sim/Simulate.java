package edu.ntnu.idatt2001.wargamesdel1.sim;

/**
 * runs the game/simulation
 * @author birk
 *  @version 1.01 06.03.2022
 */
public class Simulate {
    /**
     * main method to run the program
     * @param args
     */
    public static void main(String[] args) {

        Client client = new Client();

        System.out.println(client.createBattle().simulate());
    }
}

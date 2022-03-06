package edu.ntnu.idatt2001.wargamesdel1.sim;

/**
 * runs the game/simulation
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

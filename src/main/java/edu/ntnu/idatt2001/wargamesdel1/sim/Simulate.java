package edu.ntnu.idatt2001.wargamesdel1.sim;

/**
 * runs the game/simulation
 */
public class Simulate {
    public static void main(String[] args) {

        Client client = new Client();

        System.out.println(client.createBattle().simulate());
    }
}

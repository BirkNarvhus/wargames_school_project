package wargamesdel1.sim;

import wargamesdel1.army.Army;
import wargamesdel1.units.ComanderUnit;

public class Simulate {
    public static void main(String[] args) {
        ComanderUnit c = new ComanderUnit("test 1", 150);
        System.out.println(c);

        Army army = new Army("test2");
        army.addUnit(c);

        System.out.println(army.stringAll());
    }
}

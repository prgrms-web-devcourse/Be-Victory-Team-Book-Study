package chapter5.DIP;

import chapter5.DIP.driver.BestDriver;
import chapter5.DIP.driver.WorstDriver;
import chapter5.DIP.tire.NormalTire;
import chapter5.DIP.tire.SnowTire;

public class Driver {
    public static void main(String[] args) {
        Car.goHome(new BestDriver(), new SnowTire());
        Car.goHome(new WorstDriver(), new NormalTire());
    }
}

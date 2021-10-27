package chapter5.DIP;

import chapter5.DIP.driver.Driver;
import chapter5.DIP.tire.Tire;

public class Car {
    static void goHome(Driver driver, Tire tire) {
        driver.drive();
        tire.roll();
    }
}

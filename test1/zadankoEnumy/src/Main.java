import common.FuelType;

import java.util.ArrayList;

import static common.FuelType.DIESEL;
import static common.FuelType.PETROL;

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car("Volvo", "XC60", 2019, DIESEL, 50, 75, 10, 5);
        Motorcycle motorcycle1 = new Motorcycle("Harley", "Davidson", 2000, PETROL, 20, 30, 5);

//        car1.refuel(10);
//        motorcycle1.refuel(5);
//        car1.drive();
//        car1.displayInfo();
//        motorcycle1.drive();
//        motorcycle1.displayInfo();

        ArrayList<Vehicle> pojazdy = new ArrayList<>();
        pojazdy.add(car1);
        pojazdy.add(motorcycle1);

        for (Vehicle vehicle : pojazdy) {
            vehicle.displayInfo();
        }

        ArrayList<Drivable> jedziemy = new ArrayList<>();
        jedziemy.add(car1);
        jedziemy.add(motorcycle1);

        for (Drivable drivable : jedziemy) {
            drivable.drive();
        }

        car1.refuel(9.5);
    }
}
import common.FuelType;

public class Car extends Vehicle implements Drivable{
    int doors;

    public Car(String brand, String model, int year, FuelType fuel, double fuelCondition, double maxFuel, double averageFuelConsumption, int doors) {
        super(brand, model, year, fuel, fuelCondition, maxFuel, averageFuelConsumption);
        this.doors = doors;
    }

    @Override
    public void drive() {
        System.out.println("Samochód jedzie.");
    }
}

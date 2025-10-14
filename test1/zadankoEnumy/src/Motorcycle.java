import common.FuelType;

public class Motorcycle extends Vehicle implements Drivable{
    public Motorcycle(String brand, String model, int year, FuelType fuel, double fuelCondition, double maxFuel, double averageFuelConsumption) {
        super(brand, model, year, fuel, fuelCondition, maxFuel, averageFuelConsumption);
    }

    @Override
    public void drive() {
        System.out.println("Motocykl jedzie.");
    }
}

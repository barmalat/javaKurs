import common.FuelType;

public class Car extends Vehicle implements Drivable {
    int doors;

    public Car(String brand, String model, int year, FuelType fuel, double fuelCondition, double maxFuel, double averageFuelConsumption, int doors) {
        super(brand, model, year, fuel, fuelCondition, maxFuel, averageFuelConsumption);
        this.doors = doors;
    }

    @Override
    public void drive(double kilometers) {
        double fuelConsumption = calculateFuelConsuption(kilometers);
        if (fuelConsumption <= fuelCondition) {
            System.out.println("Samochód jedzie.");
            fuelCondition -= fuelConsumption;
        } else {
            double maxDrive = fuelCondition / averageFuelConsumption * 100;
            System.out.println("Masz za mało paliwa, żeby tyle przejechać! Starczy ci na maksymalnie " + maxDrive + " km.");
        }
    }
}
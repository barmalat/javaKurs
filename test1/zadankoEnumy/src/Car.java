import common.FuelType;

public class Car extends Vehicle implements Drivable {
    int doors;

    public Car(String brand, String model, int year, FuelType fuel, double fuelCondition, double maxFuel, double averageFuelConsumption, int doors) {
        super(brand, model, year, fuel, fuelCondition, maxFuel, averageFuelConsumption);
        this.doors = doors;
    }
    private double calculateFuelConsuption(double kilometers){
        return kilometers * averageFuelConsumption / 100;
    }

    @Override
    public void drive(double kilometers) {
        double fuelConsuption = calculateFuelConsuption(kilometers);
        if (fuelConsuption <= fuelCondition) {
            System.out.println("Samochód jedzie.");
            fuelCondition -= fuelConsuption;
        } else {
            double maxDrive = fuelCondition / averageFuelConsumption * 100;
            System.out.println("Masz za mało paliwa, żeby tyle przejechać! Starczy ci na maksymalnie " + maxDrive + " km.");
        }
    }
}
import common.FuelType;

public class Motorcycle extends Vehicle implements Drivable{
    public Motorcycle(String brand, String model, int year, FuelType fuel, double fuelCondition, double maxFuel, double averageFuelConsumption) {
        super(brand, model, year, fuel, fuelCondition, maxFuel, averageFuelConsumption);
    }

    @Override
        public void drive(double kilometers) {
        double fuelConsumption = calculateFuelConsuption(kilometers);
        if (fuelConsumption <= fuelCondition) {
            System.out.println("Motocykl jedzie.");
            fuelCondition -= fuelConsumption;
        } else {
            double maxDrive = fuelCondition / averageFuelConsumption * 100;
            System.out.println("Masz za mało paliwa, żeby tyle przejechać! Starczy ci na maksymalnie " + maxDrive + " km.");
        }
    }
}
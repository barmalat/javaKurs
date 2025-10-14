import common.FuelType;

public abstract class Vehicle {
    String brand;
    String model;
    int year;
    FuelType fuel;
    double fuelCondition;
    double maxFuel;
    double averageFuelConsumption;

    @Override
    public String toString() {
        return "Vehicle{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", fuel=" + fuel +
                ", fuelCondition=" + fuelCondition +
                ", maxFuel=" + maxFuel +
                ", averageFuelConsumption=" + averageFuelConsumption +
                '}';
    }

    public Vehicle(String brand, String model, int year, FuelType fuel, double fuelCondition, double maxFuel, double averageFuelConsumption) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.fuel = fuel;
        this.fuelCondition = fuelCondition;
        this.maxFuel = maxFuel;
        this.averageFuelConsumption = averageFuelConsumption;
    }

    void displayInfo() {
        System.out.println(toString());
    }

    ;

    void refuel(double liters) {
        if (liters + fuelCondition <= maxFuel) {
            double result = liters * fuel.getPrice();
            System.out.println("Tankuje pojazd za kwotę: " + result);
            refueling(liters);
            System.out.println("Masz teraz w baku: " + fuelCondition + " l.");

        } else {
            double maxAdd = maxFuel - fuelCondition;
            System.out.println("Nie możesz tyle zatankować! Maksymalnie wlejesz jeszcze " + maxAdd + " l.");
        }
    }
    void refueling(double liters){
        fuelCondition += liters;
    }
}

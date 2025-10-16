import common.FuelType;

import java.math.BigDecimal;

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

    protected void displayInfo() {
        System.out.println(toString());
    }

    protected void refuel(double liters) {
        if (liters + fuelCondition <= maxFuel) {
            BigDecimal result = fuel.getPrice().multiply(BigDecimal.valueOf(liters));
            System.out.println("Tankuje pojazd za kwotę: " + result);
            refueling(liters);
        } else {
            double maxAdd = maxFuel - fuelCondition;
            System.out.println("Nie możesz tyle zatankować! Maksymalnie wlejesz jeszcze " + maxAdd + " l.");
        }
    }

    protected double calculateFuelConsuption(double kilometers) {
        return kilometers * averageFuelConsumption / 100;
    }

    private void refueling(double liters) {
        fuelCondition += liters;
        System.out.println("Masz teraz w baku: " + fuelCondition + " l.");
    }
}
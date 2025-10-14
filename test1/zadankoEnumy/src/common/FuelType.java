package common;

public enum FuelType {
    PETROL(5.5),
    DIESEL(6.0),
    ELECTRIC(3.0);

    private final double price;

    public double getPrice() {
        return price;
    }

    FuelType(double price) {
        this.price = price;
    }
}

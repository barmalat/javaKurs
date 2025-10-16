package common;

import java.math.BigDecimal;

public enum FuelType {
    PETROL(new BigDecimal("5.5")),
    DIESEL(new BigDecimal("6.5")),
    ELECTRIC(new BigDecimal("3.0"));

    private final BigDecimal price;

    public BigDecimal getPrice() {
        return price;
    }

    FuelType(BigDecimal price) {
        this.price = price;
    }
}
import java.math.BigDecimal;

public class Order {
    private String description;
    private BigDecimal value;

    public Order(String description, BigDecimal value) {
        this.description = description;
        this.value = value;
    }

    public BigDecimal getValue() {
        return value;
    }
}
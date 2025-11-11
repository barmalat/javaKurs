import java.util.List;

public class Client extends Person{
    private List<Order> orders;

    public Client(String name, List<Order> orders) {
        super(name);
        this.orders = orders;
    }

    public List<Order> getOrders() {
        return orders;
    }
}

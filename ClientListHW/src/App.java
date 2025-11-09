import java.math.BigDecimal;
import java.util.List;

public class App {
    public static void main(String[] args) {
        topClients();
        System.out.println(total());
    }

    public static void topClients() {
        clients.stream()
                .filter(client -> client.getOrders().size() >= 3)
                .map(Person::getName)
                .forEach(System.out::println);
    }

    public static BigDecimal total() {
        return orders.stream()
                .map(Order::getValue)
                .reduce(BigDecimal::add)
                .orElseThrow();
    }

    public static final List<Order> orders = List.of(new Order("Piwo", BigDecimal.valueOf(90)),
            new Order("TV", BigDecimal.valueOf(600)),
            new Order("Ubrania", BigDecimal.valueOf(500)),
            new Order("Laptop", BigDecimal.valueOf(600)),
            new Order("Ubrania", BigDecimal.valueOf(900)),
            new Order("Ubrania", BigDecimal.valueOf(60)),
            new Order("Serki górskie", BigDecimal.valueOf(650)),
            new Order("Keczup łagodny", BigDecimal.valueOf(100)),
            new Order("Ubrania", BigDecimal.valueOf(900)),
            new Order("Ubrania", BigDecimal.valueOf(400)),
            new Order("Ubrania", BigDecimal.valueOf(6040)),
            new Order("Ubrania", BigDecimal.valueOf(90)),
            new Order("Ubrania", BigDecimal.valueOf(800)));

    public static final List<Client> clients = List.of(new Client("Adam Mickiewicz", List.of(orders.get(0), orders.get(1))),
            new Client("Juliusz Słowacki", List.of(orders.get(2), orders.get(3), orders.get(4))),
            new Client("Krystyna Janda", List.of(orders.get(5), orders.get(6), orders.get(7), orders.get(8), orders.get(9), orders.get(10))),
            new Client("Robert Kubica", List.of(orders.get(11), orders.get(12))));
}
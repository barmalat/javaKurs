package fromdiscord2;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    private static final List<Product> products = List.of(
            new Product("Laptop", "Electronics", new BigDecimal("3000")),
            new Product("Phone", "Electronics", new BigDecimal("2000")),
            new Product("TV", "Electronics", new BigDecimal("4000")),
            new Product("Table", "Furniture", new BigDecimal("800")),
            new Product("Chair", "Furniture", new BigDecimal("400")),
            new Product("Lamp", "Home", new BigDecimal("200"))
    );

    private static final List<Order> orders = List.of(
            new Order("Alice", "Laptop", 1, "North"),
            new Order("Bob", "Phone", 2, "North"),
            new Order("Charlie", "Laptop", 1, "West"),
            new Order("Alice", "Table", 3, "East"),
            new Order("David", "Laptop", 2, "South"),
            new Order("Eve", "TV", 1, "North"),
            new Order("Frank", "Laptop", 1, "West"),
            new Order("Alice", "Chair", 2, "North"),
            new Order("Alice", "Chair", 1, "East"),
            new Order("Eve", "Chair", 3, "North"),
            new Order("Bob", "Chair", 2, "North"),
            new Order("Charlie", "Phone", 1, "East"),
            new Order("Eve", "Lamp", 5, "South"),
            new Order("Eve", "Lamp", 3, "East")

    );

    public static void main(String[] args) {
        System.out.println(productsOrderedByMoreThanThreePeople());
    }
//    Zadania
//1. Produkty zamawiane przez więcej niż 3 różnych klientów
//      Zwróć listę nazw produktów (List<String>), które zostały zamówione przez więcej niż trzech unikalnych klientów.

    public static List<String> productsOrderedByMoreThanThreePeople() {
        return orders.stream()
                .collect(Collectors.toMap(order -> order.getClientName() + order.getProductName() + order.getRegion(), Function.identity(), (order, order2) -> order))
                .values().stream()
                .collect(Collectors.groupingBy(Order::getProductName))
                .values().stream()
                .filter(list->list.size()>3)
                .flatMap(List::stream)
                .map(Order::getProductName)
                .distinct()
                .toList();
    }

//2. Suma wydatków każdego klienta
//      Zwróć Map<String, BigDecimal> – dla każdego klienta oblicz sumę wydatków na podstawie liczby sztuk i ceny produktu.
//
//3. Dla każdej kategorii podaj zestaw regionów, w których była zamawiana
//      Zwróć Map<String, Set<String>>, gdzie kluczem jest kategoria (Product.category), a wartością zestaw regionów, w których złożono zamówienia na produkty z tej kategorii.
//
//4. Najdroższy produkt zamówiony ogółem
//      Zwróć pojedynczy obiekt Product, który był najdroższy spośród tych, które faktycznie zostały zamówione (czyli znajdują się w Order).
//
//5. Czy w każdym regionie zamawiano coś z kategorii "Electronics"?
//      Zwróć Map<String, Boolean>, gdzie kluczem jest region, a wartością true jeśli w tym regionie zamówiono jakikolwiek produkt z kategorii "Electronics".
//      podpowiastka uzyć gdzieś trzeba Collectors.reducing
}
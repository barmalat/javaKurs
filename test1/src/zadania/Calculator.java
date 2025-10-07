package zadania;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Double result;
        while (true) {
            System.out.println("Podaj pierwszą liczbę:");
            double a = scanner.nextDouble();
            System.out.println("Podaj znak działania:");
            String symbol = scanner.next();
            System.out.println("Podaj drugą liczbę:");
            double b = scanner.nextDouble();

            result = switch (symbol) {
                case "+" -> a + b;
                case "-" -> a - b;
                case "*" -> a * b;
                case "/" -> a / b;
                case "%" -> a % b;
                case "^" -> Math.pow(a, b);
                default -> {
                    System.out.println("Błędny operator");
                    yield null;
                }
            };
            if (result == null) {
                continue;
            }
            System.out.println(result);
            System.out.println("Czy chcesz kontynuować obliczenia? y/n");
            String continueSymbol = scanner.next();
            if (!continueSymbol.equals("y")) {
                break;
            }
        }
        if (result % 2 == 0) {
            System.out.println("Ostatni wynik jest parzysty.");
        } else if (result % 2 == 1) {
            System.out.println("Ostatni wynik jest nieparzysty.");
        }
    }
}
//todo: ternary i dzielenie przez 0

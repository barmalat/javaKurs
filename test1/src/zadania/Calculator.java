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

            if ((symbol.equals("/") || symbol.equals("%")) && b == 0) {
                System.out.println("Nie dziel Cholero nigdy przez zero!");
                continue;
            }

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
            if (continueSymbol.equals("n")) {
                break;
            }
        }
        System.out.println(result % 2 == 0 ? "Ostatni wynik jest parzysty." : "Ostatni wynik jest nieparzysty.");
    }
}
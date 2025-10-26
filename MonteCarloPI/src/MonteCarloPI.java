import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MonteCarloPI {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj liczbę n punktów do wygenerowania:");
        int n = scanner.nextInt();
        int counter = 0;

        for (int i = 0; i < n; i++) {
            double x = random.nextDouble(-1, 1);
            double y = random.nextDouble(-1, 1);
            if (Math.pow(x, 2) + Math.pow(y, 2) <= 1) {
                counter++;
            }
        }
        System.out.println("Ilość punktów w okręgu: " + counter);
        double pi = (double) (4 * counter) / n;
        System.out.println("Liczba PI obliczona metodą MonteCarlo wynosi: " + pi);
    }
}
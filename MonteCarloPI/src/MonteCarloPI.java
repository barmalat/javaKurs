import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MonteCarloPI {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj liczbę punktów do wygenerowania:");
        int n = scanner.nextInt();
        int nInsideCircle = 0;

        ArrayList<Double> xs = new ArrayList<>();
        ArrayList<Double> ys = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            double x = random.nextDouble(-1, 1);
            xs.add(x);
            double y = random.nextDouble(-1, 1);
            ys.add(y);
            if (Math.pow(x, 2) + Math.pow(y, 2) <= 1) {
                nInsideCircle++;
            }
        }
        System.out.println("Ilość punktów w okręgu: " + nInsideCircle);
        double pi = (double) (4 * nInsideCircle) / n;
        System.out.println("Liczba PI obliczona metodą MonteCarlo wynosi: " + pi);
    }
}
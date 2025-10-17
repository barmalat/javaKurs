import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Mapa1 {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj liczbę punktów do wygenerowania:");
        int n = scanner.nextInt();
        ArrayList<Point> points = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            Point point = new Point(random.nextInt(), random.nextInt());
            points.add(point);
        }
        System.out.println("Punkty: " + points);

        HashMap<Long, Point> pointsMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            pointsMap.put((long) points.get(i).getX(), points.get(i));
        }
        System.out.println("Mapa punktów: " + pointsMap);

        System.out.println("Liczba punktów na liście: " + points.size());
        System.out.println("Liczba punktów na mapie: " + pointsMap.size());
    }
}
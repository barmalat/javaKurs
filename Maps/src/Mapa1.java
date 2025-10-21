import java.awt.*;
import java.util.*;
import java.util.List;

public class Mapa1 {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj liczbę punktów do wygenerowania:");
        int n = scanner.nextInt();
        List<Point> points = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            Point point = new Point(random.nextInt(10), random.nextInt(10));
            points.add(point);
        }
        System.out.println("Punkty: " + points);

        Map<Long, List<Point>> pointsMap = new HashMap<>();

        for (Point point : points) {
            if (pointsMap.keySet().contains(point.x)) {
                pointsMap.get(point.x).add(point);
            } else {
                List<Point> xPoints = new ArrayList<>();
                pointsMap.put((long) point.x, xPoints);
                xPoints.add(point);
            }
        }

        System.out.println("Mapa punktów:" + pointsMap);
    }
}
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class SharedResource3 {
    private Integer value = null;
    private final Queue<Integer> kolejka = new LinkedList<>();

    public void produce() {
        synchronized (kolejka) {
            while (kolejka.size() == 30) {
                try {
                    kolejka.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            value = new Random().nextInt();
            kolejka.add(value);
            System.out.println("producing value: " + value + " stan kolejki: " + kolejka.size());
            kolejka.notifyAll();
        }
    }

    public void consume() {
        synchronized (kolejka) {
            while (kolejka.isEmpty()) {
                try {
                    kolejka.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println(Thread.currentThread().getName() + " consuming value: " + kolejka.poll() + " stan kolejki: " + kolejka.size());
            kolejka.notifyAll();
        }
    }
}
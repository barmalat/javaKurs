import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

import static java.lang.Thread.sleep;

public class SharedResource2 {
    private Integer value = null;
    Queue kolejka = new LinkedList();

    public synchronized void produce() {
        while (kolejka.size() == 5) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        value = new Random().nextInt();
        kolejka.add(value);
        System.out.println("producing value: " + value + " stan kolejki: " + kolejka.size());
        try {
            sleep(new Random().nextInt(600));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        notifyAll();
    }

    public synchronized void consume() {
        while (kolejka.size() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(Thread.currentThread().getName() + " consuming value: " + kolejka.poll() + " stan kolejki: " + kolejka.size());
        try {
            sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        notifyAll();
    }
}
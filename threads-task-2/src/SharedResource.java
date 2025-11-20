import java.util.Random;
import static java.lang.Thread.sleep;

public class SharedResource {
    private Integer value = null;

    public synchronized void produce() {
        while (value != null) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        value = new Random().nextInt();
        System.out.println("producing value: " + value);
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        notify();
    }

    public synchronized void consume() {
        while (value == null) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("consuming value: " + value);
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        value = null;
        notify();
    }
}
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SharedResource4 {
    private final Queue<Integer> kolejka = new LinkedList<>();
    private final int MAX_SIZE = 20;
    private Integer value = null;

    private final Lock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();

    public void produce() {
        lock.lock();
        try {
            while (kolejka.size() == MAX_SIZE) {
                notFull.await();
            }
            value = new Random().nextInt();
            kolejka.add(value);

            System.out.println("producing value: " + value + " stan kolejki: " + kolejka.size());

            notEmpty.signalAll();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    public void consume() {
        lock.lock();
        try {
            while (kolejka.isEmpty()) {
                notEmpty.await();
            }
            System.out.println(Thread.currentThread().getName() + " consuming value: " + kolejka.poll() + " stan kolejki: " + kolejka.size());

            notFull.signal();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }
}
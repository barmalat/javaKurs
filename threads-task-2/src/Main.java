import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Runnable incrementCounter10000times = () -> IntStream.range(0,10000).forEach(i->counter.increment());
        Thread t1 = new Thread(incrementCounter10000times);
        Thread t2 = new Thread(incrementCounter10000times);
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(counter.getCounter());
    }
}
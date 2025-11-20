import java.util.Random;
import java.util.stream.IntStream;

import static java.lang.Thread.sleep;

public class Main4 {
    public static void main(String[] args) {
        SharedResource4 sharedResource4 = new SharedResource4();
        Thread consumer = new Thread(() -> IntStream.range(0, 100).forEach(i -> {
            try {
                sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            sharedResource4.consume();
        }));
        Thread consumer2 = new Thread(() -> IntStream.range(0, 100).forEach(i -> {
            try {
                sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            sharedResource4.consume();
        }));
        Thread consumer3 = new Thread(() -> IntStream.range(0, 100).forEach(i -> {
            try {
                sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            sharedResource4.consume();
        }));
        Thread producer = new Thread(() -> IntStream.range(0, 300).forEach(i -> {
            try {
                sleep(new Random().nextInt(1000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            sharedResource4.produce();
        }));
        consumer.start();
        consumer2.start();
        consumer3.start();
        producer.start();
    }
}
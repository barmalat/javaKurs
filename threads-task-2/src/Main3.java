import java.util.stream.IntStream;

public class Main3 {
    public static void main(String[] args) {
        SharedResource2 sharedResource2 = new SharedResource2();
        Thread consumer = new Thread(()-> IntStream.range(0, 10).forEach(i->sharedResource2.consume()));
        Thread consumer2 = new Thread(()-> IntStream.range(0, 10).forEach(i->sharedResource2.consume()));
        Thread consumer3 = new Thread(()-> IntStream.range(0, 10).forEach(i->sharedResource2.consume()));
        Thread producer = new Thread(()-> IntStream.range(0, 30).forEach(i->sharedResource2.produce()));
        consumer.start();
        consumer2.start();
        consumer3.start();
        producer.start();
    }
}
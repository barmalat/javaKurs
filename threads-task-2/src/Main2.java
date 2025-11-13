import java.util.stream.IntStream;

public class Main2 {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();
        Thread consumer = new Thread(()-> IntStream.range(0, 100).forEach(i->sharedResource.consume()));
        Thread producer = new Thread(()-> IntStream.range(0, 100).forEach(i->sharedResource.produce()));
        consumer.start();
        producer.start();
    }
}
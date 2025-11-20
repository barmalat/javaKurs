import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MatrixSum {
    private static final int ARRAY_SIZE = 1_000_000_000;
    private static final int THREAD_COUNT = 4;

    public static void main(String[] args) {
        int[] array = new int[ARRAY_SIZE];
        List<Thread> threads = new ArrayList<>();
        Arrays.fill(array, 1);
        long startTime = System.currentTimeMillis();

        int factor = ARRAY_SIZE / THREAD_COUNT;

        try (ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT)) {
            for (int i = 0; i < THREAD_COUNT; i++) {
                final int start = i * factor;
                final int end = (i == THREAD_COUNT - 1) ? ARRAY_SIZE : start + factor;
                Thread thread = new Thread(new MyThread(start, end, array));
                threads.add(thread);
                executorService.submit(thread::start);
            }
        }

        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Suma = " + MyThread.totalSum);
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }
}
import java.util.Arrays;

public class MatrixSum {
    private static final int ARRAY_SIZE = 10000;
    private static final int THREAD_COUNT = 4;

    public static void main(String[] args) {
        int [] array = new int[ARRAY_SIZE];
        Arrays.fill(array, 1);

        long[] partialSums = new long[THREAD_COUNT];
        Thread[] threads = new Thread[THREAD_COUNT];

        int chunkSize = ARRAY_SIZE / THREAD_COUNT;

        for (int i = 0; i < THREAD_COUNT; i++) {
            final int threadIndex = i;
            final int start = i * chunkSize;
            final int end = (i == THREAD_COUNT - 1) ? ARRAY_SIZE : start + chunkSize;

            threads[i] = new Thread(() -> {
                long sum = 0;
                for (int j = start; j < end; j++) {
                    sum += array[j];
                }
                partialSums[threadIndex] = sum;
            });
            threads[i].start();
        }
        for (Thread t : threads){
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        long totalSum = 0;
        for (long s : partialSums){
            totalSum += s;
        }
        System.out.println("Suma = " + totalSum);
    }
}
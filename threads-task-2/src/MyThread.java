public class MyThread implements Runnable {
    private final int start;
    private final int end;
    private final int[] array;

    static long totalSum;

    public MyThread(int start, int end, int[] array) {
        this.start = start;
        this.end = end;
        this.array = array;
    }

    @Override
    public void run() {
        long sum = 0;
        for (int j = start; j < end; j++) {
            sum += array[j];
        }
        totalSum += sum;
    }
}

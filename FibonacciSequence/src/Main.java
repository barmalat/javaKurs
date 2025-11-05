import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("60: " + nTermOfTheFibonacciSequence(60));
    }

    static List<Long> memory = new ArrayList<>();

    static {
        memory.add(0L);
        memory.add(1L);
    }

    public static long nTermOfTheFibonacciSequence(int n) {
        if (memory.size() <= n) {
            Long result = nTermOfTheFibonacciSequence(n - 1) + nTermOfTheFibonacciSequence(n - 2);
            memory.add(result);
        }
            return memory.get(n);
    }
}
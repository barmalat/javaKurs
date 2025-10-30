package fromdiscord;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class task1 {
    public static void main(String[] args) {
        System.out.println(numbersMethod(integer -> integer % 2 == 0));
    }

    public static final List<Integer> numbers = Arrays.asList(1, 2, 3, 10, 15, 20);

    public static List<Integer> numbersMethod(Predicate<Integer> predicate) {
        return numbers
                .stream()
                .filter(predicate)
                .toList();
    }
}
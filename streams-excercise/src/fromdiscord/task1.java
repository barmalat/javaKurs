package fromdiscord;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class task1 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 10, 15, 20);

        System.out.println(numbersMethod(numbers, integer -> integer % 2 == 0));
    }

    public static List<Integer> numbersMethod(List<Integer> list, Predicate<Integer> predicate) {
        return list.stream()
                .filter(predicate)
                .toList();
    }
}
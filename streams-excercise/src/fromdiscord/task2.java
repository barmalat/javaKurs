package fromdiscord;

import java.util.function.Function;

public class task2 {
    public static void main(String[] args) {
        Function<String, String> trim = a -> a.trim();
        Function<String, String> toUpperCase = a -> a.toUpperCase();
        Function<String, String> both = trim.andThen(toUpperCase);
        Function<String, String> both2 = trim.compose(toUpperCase);

        String test = "   teSt   ";

        System.out.println(trim.apply(test));
        System.out.println(toUpperCase.apply(test));
        System.out.println(both.apply(test));
        System.out.println(both2.apply(test));
    }
}
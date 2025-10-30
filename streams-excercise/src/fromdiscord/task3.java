package fromdiscord;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class task3 {
    public static void main(String[] args) {
        List<String> sentences = Arrays.asList("hello world", "java streams", "world of code");

        String test = sentences
                .stream()
                .flatMap(string-> Arrays.stream(string.split(" ")))
                .distinct()
                .sorted()
                .collect(Collectors.joining(","));

        System.out.println("adwd "+test);
    }
}

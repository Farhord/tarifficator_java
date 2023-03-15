import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Streams {
    public List<String> mapIntegerToList() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            numbers.add((int) (Math.random() * 1000));
        }

        List<String> strings = numbers.stream()
                .filter((n) -> n % 2 == 0)
                .map((integer -> "Number: " + integer))
                .filter((string) -> string.endsWith("0"))
                .map((string) -> string + "!")
                .collect(Collectors.toList());

        return strings;
    }
}

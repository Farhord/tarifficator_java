import java.util.Optional;

public class Optionals {

    public Optional<String> tryCreateEmptyOptional() {
        Optional<String> empty = Optional.empty();
        return empty;
    }

    public Optional<String> tryCreateNotEmptyOptional() {
        String name = "Hello World!";
        Optional<String> opt = Optional.of(name);
        return opt;
    }
}

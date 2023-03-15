import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Streams streams = new Streams();
        List<String> stringsFromStream;
        stringsFromStream = streams.mapIntegerToList();
        System.out.println(stringsFromStream);

        Optionals optionals = new Optionals();
        System.out.println("\n" + optionals.tryCreateEmptyOptional());
        System.out.println(optionals.tryCreateNotEmptyOptional());

        JavaNIO nio = new JavaNIO();
        try {
            nio.tryNio();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Time time = new Time();
        LocalDateTime localDateTime = time.getTime();
        System.out.println("\nLocal time: " + localDateTime);
    }
}
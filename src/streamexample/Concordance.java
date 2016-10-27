package streamexample;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Concordance {
    public static void main(String[] args) throws Throwable {
        try (Stream<String> stream = Files.lines(Paths.get("PrideAndPrejudice.txt"))) {
            stream
                    .flatMap(l->Stream.of(l.split("\\W+")))
                    .filter(s->s.length() > 0)
                    .map(String::toLowerCase)
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                    .entrySet().stream()
                    .sorted((e,f)->f.getValue().compareTo(e.getValue()))
                    .limit(200)
                    .forEach(System.out::println);
        }
//        catch (IOException ioe) {
//            System.out.println("Something broke " + ioe.getMessage());
//        }
    }
}

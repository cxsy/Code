import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * LambdaWithPredicateTest
 */
public class LambdaWithPredicateTest {
    public static void filterTest(List<String> languages, Predicate<String> condition) {
        languages.stream().filter(condition).forEach(System.out::println);
    }

    public static void main(String[] args) {
        List<String> languages = Arrays.asList("Java", "Python");
        filterTest(languages, x -> x.startsWith("J"));
    }
}
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * LambdaMappingTest
 */
public class LambdaMappingTest {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        List<Integer> list = Arrays.stream(arr).filter(x -> x > 2).boxed().collect(Collectors.toList());
        list.forEach(System.out::println);
        System.out.println(Arrays.stream(arr).map(x -> x * x).reduce((sum, x) -> sum + x).getAsInt());
    }
}
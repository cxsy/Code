import java.util.Map;
import java.util.TreeMap;

/**
 * LambdaMapTest
 */
public class LambdaMapTest {
    public static void main(String[] args) {

        TreeMap<Integer, Integer> tm = new TreeMap<>((x, y) -> x * x - y * y);
        tm.put(2, 3);
        tm.put(-3, 4);
        tm.keySet().forEach(System.out::println);
        
    }

}
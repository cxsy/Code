import java.util.Arrays;
import java.util.List;

public class Demo6 {
    public int add(List<Integer> values) {
        values.parallelStream().forEachOrdered(System.out::println);
        // return values.parallelStream().mapToInt(a -> a).sum();
        return 0;
    }

    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(10, 20, 30, 40);
        int res = new Demo6().add(values);
        // System.out.println("计算结果为: " + res);
    }
}
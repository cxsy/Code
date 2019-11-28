import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LambdaTest
 */
@FunctionalInterface
interface interfaceTest {
    public void print1();

    // public void print2();

    // public void print2();
}

public class LambdaTest {
    public static void print(interfaceTest it) {
        it.print1();
    }

    public static void main(String[] args) {
        print(() -> System.out.println("Hello World!"));
        new Thread(() -> {
            System.out.println("Hello World!");
        }).start();
        List<String> languages = Arrays.asList("java", "python");
        languages.forEach(x -> System.out.println(x));
        class Node {
            int x, y;

            Node(int x, int y) {
                this.x = x;
                this.y = y;
            }

            @Override
            public String toString() {
                return this.x + " " + this.y;
            }
        }
        List<Node> list = Arrays.asList(new Node(1, 3), new Node(2, 2));
        list.sort((a, b) -> a.x * a.x + a.y * a.y - b.x * b.x - b.y * b.y);
        list.forEach(x -> System.out.println(x));
    }
}
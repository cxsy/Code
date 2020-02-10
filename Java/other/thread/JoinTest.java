import java.util.LinkedList;
import java.util.List;

/**
 * JoinTest
 */
public class JoinTest {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        ReentrantLockTest
        list.poll()
        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(Thread.currentThread().getName() + ": " + i);
                }
            }
        });
        t.start();
        try {
            t.join();
        } catch (Exception e) {
            // TODO: handle exception
        }
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }
}
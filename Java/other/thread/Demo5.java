import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 用线程池的方法创建线程 Demo5
 */
public class Demo5 {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 1000; i++) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }
        threadPool.shutdown();
    }
}
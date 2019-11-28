import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * CallFutureTest
 */
public class CallFutureTest implements Callable<Integer> {

    public static void main(String[] args) {
        CallFutureTest cft = new CallFutureTest();
        FutureTask<Integer> ft = new FutureTask<>(cft);
        new Thread(ft, "有返回值的线程").start();
        try {
            System.out.println("子线程的返回值： " + ft.get());
        } catch (Exception e) {
            // TODO: handle exception
        }
        System.out.println("主线程执行完毕");
    }

    @Override
    public Integer call() throws Exception {
        int i = 0;
        while (i < 100) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            i++;
        }
        return i;
    }
}
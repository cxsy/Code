import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * 带返回值的线程
 * Demo3
 */
public class Demo3 implements Callable<Integer> {
    public Integer call() throws Exception {
        System.out.println("正在进行计算......");
        Thread.sleep(1000);
        return 1;
    }

    public static void main(String[] args) {
        Demo3 d = new Demo3();
        FutureTask<Integer> task = new FutureTask<>(d);
        Thread t = new Thread(task);
        t.start();
        System.out.println("我先干点别的...");
        try {
            System.out.println("线程执行的结果为：" + task.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
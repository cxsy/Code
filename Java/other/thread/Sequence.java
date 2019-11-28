import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// import java.util.concurrent.atomic.AtomicInteger;

/**
 * Sequence
 */
public class Sequence {

    // private MyLock lock = new MyLock();
    private MyLock2 lock = new MyLock2();
    private int value;
    // private AtomicInteger value = new AtomicInteger();
    static int static_value;

    /**
     * synchronized 修饰普通方法时，内置锁的对象就是当前类的实例
     * 
     * @return
     */
    public int getNext() {
        // lock.lock(); // lock需要显示地获取和释放锁
        // int a = value++; // 使用lock可以方便地实现公平性
        // lock.unlock(); // 非阻塞地获取锁
        // return a; // 能被中断地获取锁
        lock.lock();
        try {
            Thread.sleep(100);
            return value++;
        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            lock.unlock();
        }
    } // 超时获取锁

    /**
     * synchronized 修饰静态方法时，内置锁的对象为当前类的class属性
     * 
     * @return
     */
    public static int getStaticNext() {
        // monitorenter
        synchronized (Integer.valueOf(static_value)) {
            return static_value--;
        }
        // monitorexit
    }

    public static void main(String[] args) {
        Sequence s1 = new Sequence();
        // Sequence s2 = new Sequence();
        // while (true) {
        // System.out.println(s.getNext());
        // }
        new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    System.out.println(Thread.currentThread().getName() + " " + s1.getNext());
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    System.out.println(Thread.currentThread().getName() + " " + s1.getNext());
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        // new Thread(new Runnable() {

        // @Override
        // public void run() {
        // while (true) {
        // System.out.println(Thread.currentThread().getName() + " " +
        // Sequence.getStaticNext());
        // try {
        // Thread.sleep(100);
        // } catch (Exception e) {
        // e.printStackTrace();
        // }
        // }
        // }
        // }).start();
        // new Thread(new Runnable() {

        // @Override
        // public void run() {
        // while (true) {
        // System.out.println(Thread.currentThread().getName() + " " +
        // Sequence.getStaticNext());
        // try {
        // Thread.sleep(100);
        // } catch (Exception e) {
        // e.printStackTrace();
        // }
        // }
        // }
        // }).start();
    }
}
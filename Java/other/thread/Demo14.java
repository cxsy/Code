import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Demo14
 */
public class Demo14 {

    private Map<String, Object> map = new HashMap<>();
    private ReadWriteLock rwl = new ReentrantReadWriteLock();
    private Lock rl = rwl.readLock();
    private Lock wl = rwl.writeLock();

    public Object get(String key) {
        rl.lock();
        System.out.println(Thread.currentThread().getName() + " 读操作在执行...");
        try {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
            }
            return map.get(key);
        } finally {
            rl.unlock();
            System.out.println(Thread.currentThread().getName() + " 读操作执行完毕...");
        }
    }

    public void put(String key, Object value) {
        wl.lock();
        System.out.println(Thread.currentThread().getName() + " 写操作在执行...");
        try {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
            }
            map.put(key, value);
        } finally {
            wl.unlock();
            System.out.println(Thread.currentThread().getName() + " 写操作执行完毕...");
        }
    }

    public static void main(String[] args) {
        Demo14 d = new Demo14();
        d.put("key1", "value1");
        // new Thread(new Runnable() {

        // @Override
        // public void run() {
        // d.put("key1", "value1");
        // }
        // }).start();
        new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println(d.get("key1"));
            }
        }).start();
        new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println(d.get("key1"));
            }
        }).start();
        new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println(d.get("key1"));
            }
        }).start();
        // new Thread(new Runnable() {

        // @Override
        // public void run() {
        // d.put("key2", "value2");
        // }
        // }).start();
        // new Thread(new Runnable() {

        // @Override
        // public void run() {
        // d.put("key3", "value3");
        // }
        // }).start();
        // new Thread(new Runnable() {

        // @Override
        // public void run() {
        // d.put("key4", "value4");
        // }
        // }).start();
    }
}
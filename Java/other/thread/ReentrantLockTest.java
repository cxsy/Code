import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLockTest
 */
public class ReentrantLockTest {

    ReentrantLock rl = new ReentrantLock();
    private int num = 0;

    public void count() {
        for (int i = 0; i < 10; i++) {
            try {
                rl.lock();
                num++;
                System.out.println(num);
            } catch (Exception e) {
                // TODO: handle exception
            } finally {
                rl.unlock();
            }
        }
    }

    public static void main(String[] args) {
        ReentrantLockTest rlt = new ReentrantLockTest();
        new Thread(() -> rlt.count()).start();
        new Thread(() -> rlt.count()).start();
    }
}
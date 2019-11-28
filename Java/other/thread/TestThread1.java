/**
 * TestThread1
 */
public class TestThread1 {

    public static void main(String[] args) {
        Runner1 r = new Runner1();
        // r.run();
        // Thread t = new Thread(r);
        r.start();
        for (int i = 0; i < 100; i++) {
            System.out.println("Main Thread:------" + i);
        }
    }
}

class Runner1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Runner1 : " + i);
        }
    }
}
/**
 * Demo13
 */
public class Demo13 {

    MyLock2 lock = new MyLock2();

    public void a() {
        lock.lock();
        System.out.println("a");
        b();
        lock.unlock();
    }

    public void b() {
        lock.lock();
        System.out.println("b");
        c();
        lock.unlock();
    }

    public void c() {
        lock.lock();
        System.out.println("c");
        lock.unlock();
    }

    public static void main(String[] args) {
        Demo13 d = new Demo13();
        new Thread(new Runnable() {

            @Override
            public void run() {
                d.a();
            }
        }).start();
    }
}
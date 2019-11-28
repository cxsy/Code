/**
 * Demo10
 */
public class Demo10 {
    private Object obj1 = new Object();
    private Object obj2 = new Object();

    public void a() {
        synchronized (obj1) {
            try {
                Thread.sleep(20);
            } catch (Exception e) {
                // TODO: handle exception
            }
            synchronized (obj2) {
                System.out.println("Hello from a");
            }
        }
    }

    public void b() {
        synchronized (obj2) {
            try {
                Thread.sleep(20);
            } catch (Exception e) {
                // TODO: handle exception
            }
            synchronized (obj1) {
                System.out.println("Hello from b");
            }
        }
    }

    public static void main(String[] args) {
        Demo10 d = new Demo10();
        new Thread(new Runnable() {

            @Override
            public void run() {
                d.a();
            }
        }).start();
        new Thread(new Runnable() {

            @Override
            public void run() {
                d.b();
            }
        }).start();
    }
}
/**
 * Demo8
 */
public class Demo8 {

    public synchronized void a() {
        System.out.println("a");
        b();
    }

    public synchronized void b() {
        System.out.println("b");
        try {
            Thread.sleep(100);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public static void main(String[] args) {
        Demo8 d1 = new Demo8();
        Demo8 d2 = new Demo8();
        new Thread(new Runnable() {

            @Override
            public void run() {
                d1.a();
            }
        }).start();
        // new Thread(new Runnable() {

        // @Override
        // public void run() {
        // d1.a();
        // }
        // }).start();
    }
}
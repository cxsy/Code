/**
 * Demo12
 */
public class Demo12 {

    private int a = 1;

    public synchronized int getA() {
        // return a;
        return 1;
    }

    public synchronized void setA(int a) {
        try {
            Thread.sleep(10);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // this.a = a;
        System.out.println("from set");
    }

    public static void main(String[] args) {
        Demo12 d = new Demo12();
        new Thread(new Runnable() {

            @Override
            public void run() {
                d.setA(10);
            }
        }).start();
        new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println(d.getA());
            }
        }).start();
        try {
            Thread.sleep(20);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("最终结果：" + d.getA());
    }
}
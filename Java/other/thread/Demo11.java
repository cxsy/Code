/**
 * volatile是轻量级锁，被volatile修饰的变量，在线程之间是可见的
 * 可见：一个线程修改了这个变量的值，在另外一个线程中能够读到这个修改后的值
 * synchronized是重量级锁，除了线程之间互斥外，还有一个非常大的作用，就是保证可见性。
 * Demo11
 */
public class Demo11 {
    public volatile boolean run = false;    //保证针对变量的原子性操作可见

    public static void main(String[] args) {
        Demo11 d = new Demo11();
        new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("执行了第" + i + "次");
                    try {
                        Thread.sleep(50);
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                    if (i == 5) {
                        d.run = true;
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {

            @Override
            public void run() {
                while (!d.run) {
                }
                System.out.println("线程2执行");
            }
        }).start();
    }

}
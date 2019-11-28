import java.util.Random;

/**
 * Demo9
 */
public class Demo9 {

    public static void main(String[] args) {
        new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " 开始工作！");
                try {
                    Thread.sleep(new Random().nextInt(2000));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " 结束工作！");
            }
        }).start();
        new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " 开始工作！");
                try {
                    Thread.sleep(new Random().nextInt(2000));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " 结束工作！");
            }
        }).start();
        new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " 开始工作！");
                try {
                    Thread.sleep(new Random().nextInt(2000));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " 结束工作！");
            }
        }).start();
        new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " 开始工作！");
                try {
                    Thread.sleep(new Random().nextInt(2000));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " 结束工作！");
            }
        }).start();
        new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " 开始工作！");
                try {
                    Thread.sleep(new Random().nextInt(2000));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " 结束工作！");
            }
        }).start();
        while (Thread.activeCount() != 1) {     //自旋
        }
        System.out.println("所有线程已执行完毕！");
    }
}
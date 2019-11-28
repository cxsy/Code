/**
 * 实现runnable接口的方式创建线程
 * 以及用匿名内部类的方式创建线程
 * Demo2
 */
public class Demo2 implements Runnable {
    @Override
    public void run() {
        while (true) {
            System.out.println("thread running ...");
        }
    }

    public static void main(String[] args) {
        // Thread thread = new Thread(new Demo2());
        // thread.start();
        
        //匿名内部类的方式创建线程

        // new Thread() {
        // @Override
        // public void run() {
        // System.out.println("thread start ...");
        // }
        // }.start();

        // new Thread(new Runnable() {
        // @Override
        // public void run() {
        // System.out.println("thread start ...");
        // }
        // }).start();

        // System.out.println(new Thread() {
        //     @Override
        //     public void run() {
        //         System.out.println("haha");
        //     }
        // } instanceof Thread);
        // new Thread(new Runnable() {

        // @Override
        // public void run() {
        // System.out.println("runnable ...");
        // }
        // }) {
        // @Override
        // public void run() {
        // System.out.println("thread ...");
        // }
        // }.start();
    }
}
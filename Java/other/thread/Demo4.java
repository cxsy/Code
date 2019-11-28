import java.util.Timer;
import java.util.TimerTask;

/**
 * 用计时器的方式创建线程 Demo4
 */
public class Demo4 {

    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                System.out.println("timertask is run");
            }
        }, 0, 1000);
    }
}
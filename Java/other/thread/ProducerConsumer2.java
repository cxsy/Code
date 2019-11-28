import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.Semaphore;

/**
 * ProducerConsumer2
 */

class Good {
    private int id;

    Good(int id) {
        this.id = id;
    }

    public int getID() {
        return this.id;
    }
}

class Line {
    private Integer cnt = 1;
    private Semaphore full;
    private Semaphore empty;
    private Semaphore mutex;
    private Deque<Good> line;

    Line(int capacity, int has, int concurrent) {
        full = new Semaphore(has);
        empty = new Semaphore(capacity - has);
        mutex = new Semaphore(concurrent);
        this.line = new LinkedList<>();
    }

    public void produce() throws InterruptedException {
        empty.acquire();
        mutex.acquire();
        Thread.sleep(500);
        synchronized (cnt) {
            Good newGood = new Good(cnt);
            line.addLast(newGood);
            System.out.println(
                    "Good " + newGood.getID() + " has been produced by Producer " + Thread.currentThread().getName());
            cnt++;
        }
        mutex.release();
        full.release();
    }

    public void consume() throws InterruptedException {
        full.acquire();
        mutex.acquire();
        Thread.sleep(500);
        Good good = line.removeFirst();
        System.out
                .println("Good " + good.getID() + " has been consumed by Consumer " + Thread.currentThread().getName());
        mutex.release();
        empty.release();
    }
}

class Producer implements Runnable {
    private Line line;

    Producer(Line line) {
        this.line = line;
    }

    @Override
    public void run() {
        while (true) {
            try {
                line.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable {
    private Line line;

    Consumer(Line line) {
        this.line = line;
    }

    @Override
    public void run() {
        while (true) {
            try {
                line.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ProducerConsumer2 {
    public static void main(String[] args) {
        Line line = new Line(10, 0, 2);
        Producer p1 = new Producer(line);
        Producer p2 = new Producer(line);
        Consumer c1 = new Consumer(line);
        Consumer c2 = new Consumer(line);
        new Thread(p1, "1").start();
        new Thread(p2, "2").start();
        new Thread(c1, "1").start();
        new Thread(c2, "2").start();
    }
}
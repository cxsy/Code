package com.zhiguo.LangTest;

/**
 * DeadLoopClassTest
 */
class DeadLoopClass {

    static {
        if (true) {
            System.out.println(Thread.currentThread().getName() + " init DeadLoopClass");
            while (true) {
            }
        }
    }
}

/**
 * DeadLoopClassTest
 */
public class DeadLoopClassTest {

    public static void main(String[] args) {
        Runnable script = new Runnable() {

            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " start");
                DeadLoopClass dlc = new DeadLoopClass();
                System.out.println(Thread.currentThread().getName() + " run over");
            }
        };
        new Thread(script, "Thread 1").start();
        new Thread(script, "Thread 2").start();
    }
}
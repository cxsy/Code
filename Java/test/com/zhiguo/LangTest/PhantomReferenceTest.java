package com.zhiguo.LangTest;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * PhantomReferenceTest
 */
public class PhantomReferenceTest {
    private static final List<Object> TEST_DATA = new LinkedList<>();
    private static final ReferenceQueue<TestClass> QUEUE = new ReferenceQueue<>();

    public static void main(String[] args) {
        TestClass obj = new TestClass("Test");
        PhantomReference<TestClass> phantomReference = new PhantomReference<>(obj, QUEUE);
        new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    TEST_DATA.add(new byte[1024 * 100]);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(phantomReference.get());
                }
            }
        }).start();
        new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    Reference<? extends TestClass> poll = QUEUE.poll();
                    if (poll != null) {
                        System.out.println("--- 虚引用对象被jvm回收了 ---" + poll);
                        System.out.println("--- 回收对象 ---" + poll.get());
                    }
                }
            }
        }).start();

        obj = null;

        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    static class TestClass {
        private String name;

        TestClass(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "TestClass - " + name;
        }
    }
}
package com.zhiguo.LangTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * SynchronizedListTest
 */
public class SynchronizedListTest {

    private int a = 0;
    // private List<Integer> list = Collections.synchronizedList(new ArrayList<>());
    private List<Integer> list = new ArrayList<>();

    public void add() {
        for (int i = 0; i < 10; i++) {
            synchronized (this) {
                list.add(++a);
            }
        }
    }

    public static void main(String[] args) {
        SynchronizedListTest slt = new SynchronizedListTest();
        new Thread(() -> slt.add()).start();
        new Thread(() -> slt.add()).start();
        slt.list.forEach(System.out::println);
    }
}
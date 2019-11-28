package com.zhiguo.LangTest;

import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * ConcurrentmapTest
 */
public class ConcurrentmapTest {

    public static void main(String[] args) {
        ConcurrentMap<Integer, Integer> cm = new ConcurrentHashMap<>();
        new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    cm.put(i, i);
                }
            }
        }).start();
        new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    cm.put(i, i);
                }
            }
        }).start();

    }
}
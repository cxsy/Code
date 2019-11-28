package com.zhiguo.LangTest;

import java.lang.ref.WeakReference;

/**
 * WeakReferenceTest
 */
public class WeakReferenceTest {

    public static void main(String[] args) {
        WeakReference wr = new WeakReference<>(new Object());
        System.out.println("是否被回收" + (wr.get() == null));
        System.gc();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            // TODO: handle exception
        }
        System.out.println("是否被回收" + (wr.get() == null));
    }
}
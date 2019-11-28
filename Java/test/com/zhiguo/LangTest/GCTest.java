package com.zhiguo.LangTest;

/**
 * GCTest
 */
public class GCTest {

    public GCTest reference = null;
    private static int _1MB = 1024 * 1024;
    private byte[] bigSize = new byte[2 * _1MB];

    public static void testGC() {
        GCTest test1 = new GCTest();
        GCTest test2 = new GCTest();
        test1.reference = test2;
        test2.reference = test1;
        test1 = null;
        test2 = null;
        // 强制JVM进行垃圾回收
        System.gc();
    }

    public static void main(String[] args) {
        testGC();
    }
}
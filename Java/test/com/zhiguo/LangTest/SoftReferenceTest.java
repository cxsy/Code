package com.zhiguo.LangTest;

import java.lang.ref.SoftReference;
import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * UsedMemoryTest
 */
public class SoftReferenceTest {

    private static final List<HeapObject> list = new LinkedList<>();

    public static void main(String[] args) {
        SoftReference<HeapObject> sr = new SoftReference<>(new HeapObject());
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                // TODO: handle exception
            }
            if (sr.get() != null) {
                list.add(new HeapObject());
                System.out.println("list added");
            } else {
                System.out.println("--- 软引用对象已被回收 ---");
                break;
            }
            System.gc();
        }
        System.out.println(sr);
    }

    static class HeapObject {
        byte[] bs = new byte[1024 * 1024];
    }
}
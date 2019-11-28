package com.zhiguo.LangTest;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.LinkedList;
import java.util.List;

/**
 * SoftReferenceQueueTest
 */
public class SoftReferenceQueueTest {

    static class HeapObject {
        byte[] bs = new byte[1024 * 1024];
    }

    public static void main(String[] args) {
        ReferenceQueue<HeapObject> queue = new ReferenceQueue<>();
        SoftReference<HeapObject> sr = new SoftReference<>(new HeapObject(), queue);
        List<HeapObject> list = new LinkedList<>();
        while (true) {
            try {
                // 垃圾回收器是一个优先级很低的进程。
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
        Reference<? extends HeapObject> pollRef;
        while ((pollRef = queue.poll()) != null) {
            System.out.println(pollRef);
            System.out.println(pollRef.get());
            pollRef = null;
        }
    }
}
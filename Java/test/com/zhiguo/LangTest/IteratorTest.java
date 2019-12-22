package com.zhiguo.LangTest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * IteratorTest
 */
public class IteratorTest {

    public static void main(String[] args) {
        Map<Integer, Integer> m = new HashMap<>();
        m.put(1, 2);
        m.put(2, 3);
        Iterator<Map.Entry<Integer, Integer>> it = m.entrySet().iterator();
        while (it.hasNext()) {
            // System.out.println(it.next());
            // java.util.ConcurrentModificationException
            m.remove(it.next().getKey());
            // it.remove();
        }
        System.out.println(m.size());
    }
}
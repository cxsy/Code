package com.zhiguo.LangTest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * HashMapTest
 */
public class HashMapTest {
    HashMapTest(int a) {
    }

    public static void main(String[] args) {
        Map<Integer, Integer> m = new HashMap<>();
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        Set<Integer> s = new HashSet<>();
        Map<Integer, Integer> cm = new ConcurrentHashMap<>();
        Map<Integer, Integer> lm = new LinkedHashMap<>();
        lm.put(1, 1);
        System.out.println(4 >>> 1);
    }
}
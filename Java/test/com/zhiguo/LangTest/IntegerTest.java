package com.zhiguo.LangTest;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * IntegerTest
 */
public class IntegerTest {

    public static void main(String[] args) {
        Integer a = Integer.valueOf("10");
        Integer b = Integer.valueOf(10);
        System.out.println(Integer.toHexString(16));
        System.out.println(a.compareTo(b));
        System.out.println(a.equals(b));
        System.out.println(String.format("%32s", Integer.toBinaryString(12)).replace(' ', '0'));
        System.out.println(new StringBuffer("123").reverse().toString());
        float c = a.floatValue();
        System.out.println(c);
        System.out.println(Integer.parseInt("10101110", 10));
        System.out.println(Integer.valueOf(1) instanceof Integer);
        Map<Integer, Integer> m1 = new HashMap<>();
        Map<Integer, Integer> m2 = new ConcurrentHashMap<>();
    }
}
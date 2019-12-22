package com.zhiguo.LangTest;

/**
 * AutoUnboxingTest
 */
public class AutoUnboxingTest {

    public static void main(String[] args) {
        Integer i1 = Integer.valueOf(127);
        Integer j1 = Integer.valueOf(127);
        System.out.println(i1 == j1);
        Integer i2 = Integer.valueOf(128);
        Integer j2 = Integer.valueOf(128);
        System.out.println(i2 == j2);
        int c = 128;
        System.out.println(i2 == c);
    }
}
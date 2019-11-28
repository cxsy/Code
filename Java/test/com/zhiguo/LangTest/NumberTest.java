package com.zhiguo.LangTest;

/**
 * NumberTest
 */
public class NumberTest {

    public static void main(String[] args) {
        System.out.println("Character类取值范围：[" + (int) Character.MIN_VALUE + ", " + (int) Character.MAX_VALUE + "]");// [-1<<7,(1<<7)-1]
        System.out.println("Byte类取值范围：[" + Byte.MIN_VALUE + ", " + Byte.MAX_VALUE + "]");// [-1<<7,(1<<7)-1]
        System.out.println("Short类取值范围：[" + Short.MIN_VALUE + ", " + Short.MAX_VALUE + "]");// [-1<<15,(1<<15)-1]
        System.out.println("Integer类取值范围：[" + Integer.MIN_VALUE + ", " + Integer.MAX_VALUE + "]");// [-1<<31,(1<<31)-1]
        System.out.println("Long类取值范围：[" + Long.MIN_VALUE + ", " + Long.MAX_VALUE + "]");// [-1<<63,(1<<63)-1]
        System.out.println("Float类取值范围：[" + Float.MIN_VALUE + ", " + Float.MAX_VALUE + "]");
        System.out.println("Double类取值范围：[" + Double.MIN_VALUE + ", " + Double.MAX_VALUE + "]");
    }
}
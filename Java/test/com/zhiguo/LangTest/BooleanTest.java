package com.zhiguo.LangTest;

/**
 * BooleanTest
 */
public class BooleanTest {
    public static void main(String[] args) {
        Boolean a = Boolean.valueOf(true);
        System.out.println("a为" + a);
        Boolean b = Boolean.valueOf("true");
        Boolean c = Boolean.valueOf("OK");
        System.out.println("b为" + b);
        System.out.println("c为" + c);
        System.out.println("a的booleanvalue()为" + a.booleanValue());
        System.out.println("a和b相等吗？" + a.equals(b));
    }
}
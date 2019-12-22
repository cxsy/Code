package com.zhiguo.LangTest;

/**
 * StaticOverrideTest
 */
class ABC {
    final int a = 1;

    public static void print() {
        System.out.println("Hello from ABC static method!");
    }

    void print1(int a, double b) {
    }
    // 无法以返回值类型作为重载函数的区分标准
    // int print1() {
    // return 1;
    // }

    void print1(double b, int a) {
    }

    protected void print2() {
    }

    private void print3() {
    }
}

public class StaticOverrideTest extends ABC {
    public static void print() {
        System.out.println("Hello from ABC son static method!");
    }

    @Override
    void print1() {
        // TODO Auto-generated method stub
        super.print1();
        System.out.println(a);
    }

    @Override
    public void print2() {
        // TODO Auto-generated method stub
        super.print2();
    }

    public static void main(String[] args) {
        ABC.print();
        StaticOverrideTest.print();
    }
}
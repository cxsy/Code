package com.zhiguo.LangTest;

/**
 * FinalFieldMethodTest
 */

class AAA {
    final int a = 1;

    final public void print() {
        System.out.println("Hello World!");
    }

    static void print1() {

    }

    private void print2() {
    }
}

public class FinalFieldMethodTest extends AAA {
    // 无法重写父类final method
    // public void print() {

    // }
    // 可以定义同名父类static方法，但必须仍然是static。。
    static void print1() {

    }
    //可以定义同名父类private方法，但不属于重写范畴
    private void print2() {
    }

    public static void main(String[] args) {
        FinalFieldMethodTest ffmt = new FinalFieldMethodTest();
        System.out.println(ffmt.a);
        ffmt.print();
    }
}
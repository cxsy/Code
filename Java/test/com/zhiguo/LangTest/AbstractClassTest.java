package com.zhiguo.LangTest;

/**
 * AbstractClassTest
 */

// 抽象类不能有抽象构造方法
abstract class A {
    abstract public void print();

    public static void static_print() {
        System.out.println("Hello from static method!");
    }
}

// jdk8后，接口允许static & default方法，且必须提供方法实现。

public class AbstractClassTest extends A implements InterfaceTest {
    @Override
    public void print() {
        System.out.println("Hello from abstract method!");
    }

    @Override
    public void default_print() {
        // TODO Auto-generated method stub
        InterfaceTest.super.default_print();
    }

    public static void main(String[] args) {
        static_print();
        new AbstractClassTest().print();
        new AbstractClassTest().default_print();
    }
}
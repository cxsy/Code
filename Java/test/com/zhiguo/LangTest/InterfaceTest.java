package com.zhiguo.LangTest;

/**
 * InterfaceTest
 */

// jdk8后，interface允许含有static静态方法，但必须被实现；以及default修饰的实例方法，即
// 当实现该接口的类未重写（重新实现）defualt方法，则沿用interface中default方法的函数体。
interface ii {
}

public interface InterfaceTest extends ii {
    final static int a = 1;
    final int b = 1;
    static int c = 1;

    default void default_print() {
        System.out.println("Hello from default method");
    }

    static void static_print() {
        System.out.println("Hello from static method");
    }

    private void private_method() {
        System.out.println();
    }

    // public void pp();

    public static void main(String[] args) {
        System.out.println("Hello from interface");
    }

}

abstract class AbstractClassA implements InterfaceTest {
}
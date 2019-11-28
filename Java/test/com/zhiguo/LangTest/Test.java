package com.zhiguo.LangTest;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Test
 */
interface ii {
}

class B {
    {
        System.out.println("非静态代码块！");
    }
    static {
        System.out.println("静态代码块！");
    }

    B() {
        System.out.println("构造方法代码块！");
    }

}

/**
 * Test
 */
public class Test implements ii {

    public static void main(String[] args) {
        // System.out.println(new Test() instanceof ii);
        // String s1 = new String("ab"); // 在堆（运行时） 和 常量池 （编译时） 各产生一个对象，s1指向堆内存中的对象
        // System.out.println(s1.intern() == s1); // s1.intern()返回常量池中“ab”的地址
        // String temp = "hh";
        // String s2 = "a" + temp; // 在堆（运行时）产生一个对象obj并返回
        // System.out.println(s2.intern() == s2);// s2.intern()在常量池中记录并返回首次出现的实例obj的引用
        // String s2 = "ahh";
        // System.out.println(s1 == s2);
        // String s1 = new String("计算机");
        // String s1 = new StringBuilder("计算机").append("1").toString();
        // System.out.println(s1.intern() == s1);
        // String s2 = new StringBuilder("ja").append("va").toString();
        // System.out.println(s2.intern() == s2);
        // String s1 = new String("1");
        // String s2 = s1.intern();
        // String s3 = "1";
        // System.out.println(s2 == s3);
        // System.out.println(s1 == s3);
        // String a = "a";
        // String abc = a + "bc";
        // System.out.println(abc == "abc");
        // long usedMemory = Runtime.getRuntime().totalMemory() -
        // Runtime.getRuntime().freeMemory();
        // System.out.println(new B());
        // AtomicInteger ai = new AtomicInteger();
        // String s1 = "123";
        // String s2 = "123";
        // System.out.println(s1 == s2);
        // String ss1 = new String("abc");
        // String ss2 = new String("abc");
        // System.out.println(ss1 == ss2);
        // Integer i1 = 127;
        // Integer i2 = 127;
        // System.out.println(i1 == i2);
        // Integer ii1 = 128;
        // Integer ii2 = 128;
        // System.out.println(ii1 == ii2);
        // Long l1 = 127L;
        // Long l2 = 127L;
        // System.out.println(l1 == l2);
        // Long ll1 = 128L;
        // Long ll2 = 128L;
        // System.out.println(ll1 == ll2);
        // A a = new A();
        // System.out.println(a.a);

    }
}
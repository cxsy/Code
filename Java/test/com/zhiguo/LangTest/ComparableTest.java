package com.zhiguo.LangTest;

/**
 * ComparableTest
 */

// comparable 可以作为实现类的默认排序算法
public class ComparableTest implements Comparable<ComparableTest> {
    public Integer a;

    @Override
    public int compareTo(ComparableTest o) {
        return a.compareTo(o.a);
    }

    ComparableTest(int a) {
        this.a = a;
    }

    public static void main(String[] args) {
        ComparableTest c1 = new ComparableTest(1);
        ComparableTest c2 = new ComparableTest(10);
        System.out.println(c1.compareTo(c2));
    }
}
package com.zhiguo.LangTest;

import java.util.Comparator;

/**
 * ComparatorTest
 */

// comparator接口则是一个类的拓展排序工具
public class ComparatorTest implements Comparator<ComparatorTest> {
    public Integer a;

    ComparatorTest(int a) {
        this.a = a;
    }

    @Override
    public int compare(ComparatorTest o1, ComparatorTest o2) {
        return o1.a.compareTo(o2.a);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ComparableTest) {
            return ((ComparableTest) obj).a.equals(this.a);
        }
        return false;
    }
}
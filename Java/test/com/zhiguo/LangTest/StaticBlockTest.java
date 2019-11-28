package com.zhiguo.LangTest;

/**
 * StaticBlockTest
 */
public class StaticBlockTest {

    static {
        i = 0;
        // "非法向前引用"
        // System.out.println(i);
    }
    static int i = 1;
}
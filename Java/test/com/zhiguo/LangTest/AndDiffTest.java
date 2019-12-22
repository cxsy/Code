package com.zhiguo.LangTest;

/**
 * AndDiffTest
 */
public class AndDiffTest {

    public static void main(String[] args) {
        String username = null;
        if (username != null & username.equals("")) {
            System.out.println(true);
        }
    }
}
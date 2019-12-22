package com.zhiguo.LangTest;

/**
 * JumpTest
 */
public class JumpTest {

    public static void main(String[] args) {
        int i, j;
        i = j = 0;
        A: for (i = 0; i < 10; i++) {
            for (j = 0; j < 10; j++) {
                if (i == 5 && j == 5) {
                    break A;
                }
            }
        }
        System.out.println(i + " " + j);
    }
}
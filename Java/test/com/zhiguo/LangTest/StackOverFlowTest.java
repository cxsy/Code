package com.zhiguo.LangTest;

/**
 * StackOverFlowTest
 */
public class StackOverFlowTest {

    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) throws Throwable {
        StackOverFlowTest sof = new StackOverFlowTest();
        try {
            sof.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length: " + sof.stackLength);
            throw e;
        }
    }
}
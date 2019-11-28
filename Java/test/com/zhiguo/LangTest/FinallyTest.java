package com.zhiguo.LangTest;

/**
 * FinallyTest
 */
public class FinallyTest {

    public static void main(String[] args) {
        // System.out.println(test());
        int i = 1;
        try {
            i = 4;
        } finally {
            i = 5;
        }
        System.out.println(i);
    }

    public static String test() {
        try {
            System.out.println("try block");
            return test1();
        } finally {
            System.out.println("finally block");
        }
    }

    public static String test1() {
        System.out.println("return statement");
        return "after return";
    }
}
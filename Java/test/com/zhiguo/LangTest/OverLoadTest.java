package com.zhiguo.LangTest;

/**
 * OverLoadTest
 */
public class OverLoadTest {

    static class Human {
        public void print() {
            System.out.println("hello from Human");
        }
    }

    static class Man extends Human {
        @Override
        public void print() {
            System.out.println("hello from Man");
        }
    }

    static class Woman extends Human {
        @Override
        public void print() {
            System.out.println("hello from oman");
        }
    }

    public static void sayHello(Human guy) {
        System.out.println("hello,guy!");
    }

    public static void sayHello(Man guy) {
        System.out.println("hello,gentleman!");
    }

    public static void sayHello(Woman guy) {
        System.out.println("hello,lady!");
    }

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        man.print();
        woman.print();
        // Man man = new Man();
        // Woman woman = new Woman();
        // sayHello((Man) man);
        // sayHello((Woman) woman);
    }
}
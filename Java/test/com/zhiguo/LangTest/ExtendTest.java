package com.zhiguo.LangTest;

class Parent {
    public void print() {
        System.out.println("Hello from parent class!");
    }
}

class Son1 extends Parent {
    public void son1_print() {
        System.out.println("Hello World!");
    }

    @Override
    public void print() {
        System.out.println("Hello from son1!");
    }
}

class Son2 extends Parent {
    @Override
    public void print() {
        System.out.println("Hello from son2!");
    }
}

/**
 * ExtendTest
 */

//变量声明的类型决定对外暴露的方法和属性

public class ExtendTest {
    public static void main(String[] args) {
        Parent[] p = { new Son1(), new Son2() };
        p[0].print();
        p[1].print();
        System.out.println(p[0] instanceof Parent);
    }
}
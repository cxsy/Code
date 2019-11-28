package com.zhiguo.LangTest;

/**
 * StaticResolution
 */
public class StaticResolution {

    public static void sayHello() {
        System.out.println("hello world!");
    }

    public static void main(String[] args) {
        StaticResolution.sayHello();
        // 能够正常编译，在运行期报错
        int[][][] arr = new int[1][0][-1];
    }
}   
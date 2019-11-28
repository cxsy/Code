package com.zhiguo.LangTest;

/**
 * StaticVSRuntimeConstantPool
 */
public class StaticVSRuntimeConstantPoolTest {

    public static void main(String[] args) {
        String a = "a";
        System.out.println("ab" == a + "b");
    }
}
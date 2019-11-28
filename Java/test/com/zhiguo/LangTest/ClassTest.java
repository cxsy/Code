package com.zhiguo.LangTest;

/**
 * ClassTest
 */
public class ClassTest {

    public static void main(String[] args) {
        Class objClass = String.class;
        System.out.println("String 对象的类型是: " + objClass.getName());
        objClass = Integer.class;
        System.out.println("Integer 对象的类型是: " + objClass.getName());
        try {
            objClass = Class.forName("java.lang.Character");
            System.out.println("该对象的类型是: " + objClass.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        objClass = objClass.getSuperclass();
        System.out.println("Character 对象的父类是: " + objClass.getName());
    }
}
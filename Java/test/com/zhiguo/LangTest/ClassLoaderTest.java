package com.zhiguo.LangTest;

import java.io.InputStream;

/**
 * ClassLoaderTest
 */
public class ClassLoaderTest {
    public static void main(String[] args) throws Exception {
        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                if (!name.equals("com.zhiguo.LangTest.ClassLoaderTest")) {
                    return super.loadClass(name);
                }
                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if (is == null) {
                        return super.loadClass(fileName);
                    }
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0, b.length);
                } catch (Exception e) {
                    throw new ClassNotFoundException(name);
                }
            }
        };
        // main（）函数所在的类先被系统应用程序（Application）类加载器加载
        System.out.println(ClassLoader.getSystemClassLoader());
        // obj2是自定义加载器加载的类的实例
        Object obj2 = myLoader.loadClass("com.zhiguo.LangTest.ClassLoaderTest").getConstructor().newInstance();
        System.out.println(obj2.getClass());
        // 此处com.zhiguo.LangTest.ClassLoaderTest引用系统应用程序（Application）类加载器加载的类
        System.out.println(obj2 instanceof com.zhiguo.LangTest.ClassLoaderTest);
        // ClassLoadingTest完成第一次加载，系统应用程序（Application）类加载器并没有加载
        Object obj1 = myLoader.loadClass("com.zhiguo.LangTest.ClassLoadingTest").getConstructor().newInstance();
        System.out.println(obj1.getClass());
        System.out.println(obj1 instanceof com.zhiguo.LangTest.ClassLoadingTest);
        // 此处com.zhiguo.LangTest.ClassLoaderTest引用自定义类加载器加载的类
    }
}
package com.zhiguo.LangTest;

class SuperClass {
    static {
        System.out.println("SuperClass init!");
    }

    static void print() {
        System.out.println("Hello from SuperClass");
    }

    public final static int value = 123;
}

class SubClass extends SuperClass {
    static {
        System.out.println("SubClass init!");
    }
}

/**
 * ClassLoadingTest
 */
/** 对于静态字段或方法的访问,只有直接定义这个字段的类才会被初始化(final static 修饰的常量除外) */
public class ClassLoadingTest {
    static {
        System.out.println("Main class init!");
    }

    public static void main(String[] args) {
        System.out.println(SubClass.value);/**
                                            * 常量传播优化，已经将常量的值123存储到了
                                            * ClassLoadingTest的常量池种，以后ClassLoadingTest对SubClass.value的引用实际都
                                            * 被转化为ClassLoadingTest类对自身常量池的引用了。也就是说，实际上ClassLoadingTest
                                            * 的Class文件之中并没有SubClass类的符号引用入口，这两个类在编译成Class文件后就不存在 任何联系了
                                            */
        // new SubClass();
        // SubClass.print();
    }
}
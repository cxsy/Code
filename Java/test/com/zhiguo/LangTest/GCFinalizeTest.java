package com.zhiguo.LangTest;

/**
 * GCFinalizeTest
 */
public class GCFinalizeTest {

    public static GCFinalizeTest test;

    public void isAlive() {
        System.out.println("I am alive!");
    }

    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed!");
        test = this;
    }

    public static void main(String[] args) throws Exception {
        test = new GCFinalizeTest();
        test = null;
        System.gc();
        Thread.sleep(500);
        if (test != null) {
            test.isAlive();
        } else {
            System.out.println("no,I am dead :(");
        }
        // 下面代码与上面完全一致，但是此次自救失败
        test = null;
        System.gc();
        Thread.sleep(500);
        if (test != null) {
            test.isAlive();
        } else {
            System.out.println("no,I am dead :(");
        }
    }
}
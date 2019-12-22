package com.zhiguo.LangTest;

/**
 * PrivateMethodInheritTest
 */
class AAA {
    // 不可以被继承
    private void private_print() {
    }

    public void public_print() {
    }
}

public class PrivateMethodInheritTest extends AAA {

    @Override
    public void public_print() {
        // TODO Auto-generated method stub
        super.public_print();
    }

    public static void main(String[] args) {
        PrivateMethodInheritTest pmit = new PrivateMethodInheritTest();
    }
}
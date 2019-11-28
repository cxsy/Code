package com.zhiguo.LangTest;

/**
 * StringTest
 */
public class StringTest {

    public static void main(String[] args) {
        String s0 = "abs";
        String s1 = new String("abs");
        String s2 = String.valueOf("abs");
        System.out.println(s1.hashCode() == s2.hashCode());
        System.out.println(s0.equals(s1) && s1.equals(s2));
        System.out.println(s1 == s2);
        System.out.println(s1.length());
        System.out.println(1 + 2 + "34"); // 334
        System.out.println(1 + "23" + 4); // 1234
        System.out.println("12" + 3 + 4);// 1234
        System.out.println("12".concat("34"));
        System.out.println("123" instanceof String);
        System.out.println("123".subSequence(0, 3) instanceof CharSequence);
        System.out.println("  123".trim());
        System.out.println((char) 66);
        System.out.println(" ".codePointAt(0));
        System.out.println("U+0020");
        for (char c : "123".toCharArray()) {
            System.out.println(c);
        }
    }
}
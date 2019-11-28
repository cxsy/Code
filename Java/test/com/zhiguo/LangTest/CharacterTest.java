package com.zhiguo.LangTest;

/**
 * CharacterTest
 */
public class CharacterTest {
    public static void main(String[] args) {
        int count;
        // 定义了一个字符数组
        char[] values = { '*', '_', '%', '8', 'L', 'l' };
        // 遍历字符数组
        for (count = 0; count < values.length; count++) {
            if (Character.isDigit(values[count])) {
                System.out.println(values[count] + "是一个数字");
            }
            if (Character.isLetter(values[count])) {
                System.out.println(values[count] + "是一个字母");
            }
            if (Character.isUpperCase(values[count])) {
                System.out.println(values[count] + "是大写形式");
            }
            if (Character.isLowerCase(values[count])) {
                System.out.println(values[count] + "是小写形式");
            }
            if (Character.isUnicodeIdentifierStart(values[count])) {
                System.out.println(values[count] + "是Unicode标志符的第一个有效字符");
            }
        }
        // 判断字符c是否是空白字符
        char c = ' ';
        System.out.println("字符c是空白字符吗？" + Character.isWhitespace(c));
        System.out.println(Character.valueOf('c') instanceof Character);
    }
}
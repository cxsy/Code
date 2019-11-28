package com.zhiguo.LangTest;

import java.util.Date;

/**
 * DateTest
 */
public class DateTest {
    public static void main(String[] args) {
        Date objDate = new Date();
        System.out.println("今天的日期是： " + objDate.toString());
        long time = objDate.getTime();
        System.out.println("自1970年1月1日起以毫秒为单位的时间（GMT） ：" + time);
    }

}
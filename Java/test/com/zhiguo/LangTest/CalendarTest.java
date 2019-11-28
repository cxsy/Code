package com.zhiguo.LangTest;

import java.util.*;
import java.text.*;

/**
 * CalendarTest
 */
public class CalendarTest {

    public static void main(String[] args) {
        System.out.println("完成显示日期时间： ");
        DateFormat fdate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = fdate.format(new Date());
        System.out.println(str);
        Calendar calendar = Calendar.getInstance();
        System.out.println("年： " + calendar.get(Calendar.YEAR));
        System.out.println("月： " + (calendar.get(Calendar.MONTH) + 1));
        System.out.println("日： " + calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println("当前分钟数: " + calendar.get(Calendar.MINUTE));
    }
}
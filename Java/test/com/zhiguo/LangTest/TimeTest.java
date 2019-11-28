package com.zhiguo.LangTest;

import java.time.*;
import java.time.temporal.ChronoUnit;

/**
 * TimeTest
 */
public class TimeTest {

    public static void main(String[] args) {
        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println("current date and time: " + currentTime);
        LocalDate today = LocalDate.now();
        System.out.println("current date: " + today);
        LocalDate nextDecade = today.plus(2, ChronoUnit.DECADES);
        System.out.println("20 years after now: " + nextDecade);
        LocalDate date1 = currentTime.toLocalDate();
        System.out.println("local date: " + date1);
        Month month = currentTime.getMonth();
        int day = currentTime.getDayOfMonth();
        int seconds = currentTime.getSecond();
        System.out.println("month: " + month + " day: " + day + " seconds: " + seconds);
        LocalDateTime date2 = currentTime.withDayOfMonth(10).withYear(2012);
        System.out.println("date 2: " + date2);
        LocalDate date3 = LocalDate.of(2016, Month.DECEMBER, 25);
        System.out.println("date 3 is " + date3.getDayOfWeek());
    }
}
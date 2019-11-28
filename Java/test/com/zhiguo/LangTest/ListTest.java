package com.zhiguo.LangTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * ListTest
 */
public class ListTest {

    public static void main(String[] args) {
        Integer[] il = { 1, 2, 3, 4, 5 };
        List<Integer> list = Arrays.asList(il);
        list.stream().sorted(Comparator.comparing(x -> x * x)).forEach(System.out::println);
    }
}
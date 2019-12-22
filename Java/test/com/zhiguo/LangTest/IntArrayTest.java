package com.zhiguo.LangTest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * IntArrayTest
 */
public class IntArrayTest {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        list.add(1);
    }
}
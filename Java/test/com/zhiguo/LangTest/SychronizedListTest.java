package com.zhiguo.LangTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * SychronizedListTest
 */
public class SychronizedListTest {

    public static void main(String[] args) {
        List<Integer> li = Collections.synchronizedList(new ArrayList<>());
    }
}
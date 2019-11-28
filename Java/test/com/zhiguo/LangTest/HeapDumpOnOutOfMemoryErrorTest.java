package com.zhiguo.LangTest;

import java.util.ArrayList;
import java.util.List;

/**
 * HeapDumpOnOutOfMemoryErrorTest
 */
public class HeapDumpOnOutOfMemoryErrorTest {

    static class OOMObject {
    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }
    }
}
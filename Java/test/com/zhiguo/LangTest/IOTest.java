package com.zhiguo.LangTest;

import java.io.*;

/**
 * IOTest
 */
public class IOTest {
    public void copy(InputStream in, OutputStream out) throws IOException {
        byte[] buf = new byte[4096];
        int len = in.read(buf);
        while (len != -1) {
            out.write(buf, 0, len);
            len = in.read(buf);
        }
    }

    public static void main(String[] args) {
        IOTest iotest = new IOTest();
        System.out.println("输入字符: ");
        try {
            iotest.copy(System.in, System.out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
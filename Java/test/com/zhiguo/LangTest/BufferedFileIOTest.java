package com.zhiguo.LangTest;

import java.io.*;

/**
 * BufferedFileIOTest
 */
public class BufferedFileIOTest {
    public static void main(String[] args) {
        try {
            File inFile = new File("./com/zhiguo/LangTest/in.txt");
            File outFile = new File("./com/zhiguo/LangTest/out.txt");
            BufferedInputStream bin = new BufferedInputStream(new FileInputStream(inFile), 256);
            BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(outFile), 256);
            int len;
            byte[] bArray = new byte[256];
            try {
                while ((len = bin.read(bArray)) != -1) {
                    bout.write(bArray, 0, len);
                }
                bout.flush();
            } finally {
                bin.close();
                bout.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
package com.zhiguo.LangTest;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BufferedReaderTest
 */
public class BufferedReaderTest {

    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("./com/zhiguo/LangTest/in.txt");
            InputStreamReader dis = new InputStreamReader(fis);
            BufferedReader reader = new BufferedReader(dis);
            String s;
            while ((s = reader.readLine()) != null) {
                System.out.println("read:" + s);

            }
            dis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
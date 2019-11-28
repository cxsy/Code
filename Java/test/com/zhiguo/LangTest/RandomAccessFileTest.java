package com.zhiguo.LangTest;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * RandomAccessFileTest
 */
public class RandomAccessFileTest {

    public static void main(String[] args) {
        int[] data_arr = { 12, 32, 53, 42, 12, 14 };
        try {
            RandomAccessFile randf = new RandomAccessFile("./com/zhiguo/LangTest/in.txt", "rw");
            for (int i = 0; i < data_arr.length; i++) {
                randf.writeInt(data_arr[i]);
            }
            for (int i = data_arr.length - 1; i >= 0; i--) {
                randf.seek(i * 4L);
                // System.out.println(randf.getFilePointer());
                System.out.println(randf.readInt());
            }
            randf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
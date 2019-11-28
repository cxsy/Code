package com.zhiguo.LangTest;

import java.io.*;

/**
 * DataIOTest
 */
public class DataIOTest {
    public static void main(String[] args) {
        try {
            DataOutputStream dos = new DataOutputStream(new FileOutputStream("out.txt"));
            try {
                dos.writeBoolean(true);
                dos.writeByte((byte) 123);
                dos.writeChar('3');
                dos.writeDouble(3.1415926);
                dos.writeFloat(2.122f);
                dos.writeInt(123);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    dos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            DataInputStream dis = new DataInputStream(new FileInputStream("out.txt"));
            try {
                System.out.println("\t" + dis.readBoolean());
                System.out.println("\t" + dis.readByte());
                System.out.println("\t" + dis.readChar());
                System.out.println("\t" + dis.readDouble());
                System.out.println("\t" + dis.readFloat());
                System.out.println("\t" + dis.readInt());
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    dis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
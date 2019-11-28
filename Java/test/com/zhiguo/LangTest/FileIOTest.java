package com.zhiguo.LangTest;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.SequenceInputStream;

/**
 * FileIOTest
 */
public class FileIOTest {

    public static void main(String[] args) {
        // try {
        // File inFile = new File("./com/zhiguo/LangTest/in.txt");
        // File outFile = new File("./com/zhiguo/LangTest/out.txt");
        // FileInputStream fis = new FileInputStream(inFile);
        // FileOutputStream fos = new FileOutputStream(outFile);
        // int c;
        // while ((c = fis.read()) != -1) {
        // fos.write(c);
        // }
        // fis.close();
        // fos.close();
        // } catch (FileNotFoundException e) {
        // e.printStackTrace();
        // } catch (IOException e) {
        // e.printStackTrace();
        // }
        try {
            FileInputStream f1, f2;
            String s;
            f1 = new FileInputStream("./com/zhiguo/LangTest/in.txt");
            f2 = new FileInputStream("./com/zhiguo/LangTest/in2.txt");
            SequenceInputStream fs = new SequenceInputStream(f1, f2);
            BufferedReader br = new BufferedReader(new InputStreamReader(fs));
            while ((s = br.readLine()) != null) {
                System.out.println(s);
            }
            f1.close();
            f2.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
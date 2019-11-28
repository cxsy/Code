package com.zhiguo.LangTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * TryCatchTest
 */
public class TryCatchTest {

    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("in.txt");
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            // e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
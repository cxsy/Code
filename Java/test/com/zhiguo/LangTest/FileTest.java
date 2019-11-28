package com.zhiguo.LangTest;

import java.io.File;

/**
 * FileTest
 */
public class FileTest {

    public static void main(String[] args) {
        System.out.println("separator on linux: " + File.separator);
        // 列出磁盘下的文件和文件夹
        File[] files = File.listRoots();
        for (File file : files) {
            System.out.println(file);
            String[] filenames = file.list();
            for (String filename : filenames) {
                System.out.println(filename);
            }
        }
    }
}
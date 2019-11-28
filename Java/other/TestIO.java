import java.io.*;

/**
 * TestIO
 */
public class TestIO {

    public static void main(String[] args) {
        int b = 0;
        FileInputStream in = null;
        FileOutputStream out = null;
        try {
            // in = new FileInputStream("./TestToString.java");
            out = new FileOutputStream("./Output");
            // while ((b = in.read()) != -1) {
            // out.write(b);
            // }
            for (int c = 0; c <= 50000; c++) {
                out.write(c);
            }
            // in.close();
            out.close();
        } catch (FileNotFoundException e1) {
            System.out.println("未找到指定文件");
            System.out.println(-1);
        } catch (IOException e) {
            // System.out.println("文件复制错误");
            System.out.println("文件写入错误");
            System.out.println(-1);
        }
        // System.out.println("文件复制成功");
        System.out.println("文件写入成功");
    }
}
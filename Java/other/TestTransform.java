import java.io.*;

/**
 * TestTransform
 */
public class TestTransform {

    public static void main(String[] args) {
        try {
            OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("Output"));
            osw.write("microsoft");
            System.out.println(osw.getEncoding());
            osw.close();
            osw = new OutputStreamWriter(new FileOutputStream("Output", true), "ISO8859_1");
            osw.write("Microsoft");
            System.out.println(osw.getEncoding());
            osw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
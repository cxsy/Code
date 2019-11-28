import java.io.*;

/**
 * TestObjectIO
 */
public class TestObjectIO {
    public static void main(String[] args) {
        T t = new T();
        t.k = 8;
        try {
            FileOutputStream fos = new FileOutputStream("Output");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(t);
            oos.flush();
            oos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileInputStream fis = new FileInputStream("Output");
            ObjectInputStream ois = new ObjectInputStream(fis);
            T tReaded = (T) ois.readObject();
            System.out.println(tReaded.i + " " + tReaded.j + " " + tReaded.d + " " + tReaded.k);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class T implements Serializable {
    int i = 10;
    int j = 9;
    double d = 2.3;
    transient int k = 15;
}
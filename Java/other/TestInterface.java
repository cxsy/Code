/**
 * TestInterface
 */
interface Singer {
    public void getID();

}

interface Eater {
    public void getID();
}

/**
 * TestInterface
 */
public class TestInterface implements Singer, Eater {
    @Override
    public void getID() {
        System.out.println("I'm a singer or eater");
    }

    public static void main(String[] args) {
        print(new TestInterface());
    }

    public static void print(Singer s) {
        s.getID();
    }
}
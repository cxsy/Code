/**
 * TestToString
 */
class TTSDog {
    public String toString() {
        return "I'm a cute TTSDog";
    }
}

public class TestToString {
    public static void main(String[] args) {
        TTSDog d = new TTSDog();
        TTSDog d1 = new TTSDog();
        System.out.println("d:=" + d.hashCode());
        System.out.println("d:=" + d1.hashCode());
    }
}
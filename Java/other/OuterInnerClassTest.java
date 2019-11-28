/**
 * OuterInnerClassTest
 */
public class OuterInnerClassTest {

    public static void main(String[] args) {
        // 创建一个Bean1实例bean1
        Bean1 bean1 = new OuterInnerClassTest().new Bean1();
        // 创建一个Bean2实例bean2
        Bean2 bean2 = new OuterInnerClassTest.Bean2();
        // 创建一个Bean3实例bean3
        Bean.Bean3 bean3 = new Bean().new Bean3();
        new Outter().new Inner().print();
        System.out.println(a);
    }

    OuterInnerClassTest(int a, int b) {
    }

    OuterInnerClassTest(int a) {
        this(a, 0);
    }

    class Bean1 {
        public int I = 0;
    }

    static class Bean2 {
        public int J = 0;
    }

}

class Outter {
    private int a = 1;

    class Inner {
        private int a = 2;

        public void print() {
            static class regionalClass {

            }
            int a = 3;
            System.out.println("局部变量：" + a);
            System.out.println("内部类变量：" + this.a);
            // Outter.this = None;
            System.out.println("外部类变量：" + Outter.this.a);
        }
    }
}

class Bean {
    class Bean3 {
        public int K = 0;
    }
}
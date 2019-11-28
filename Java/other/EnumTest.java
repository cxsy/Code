import java.util.HashSet;
import java.util.Set;

/**
 * EnumTest
 */
public class EnumTest {
    // 初始化时调用 枚举变量的数量 次构造函数
    enum innerEnum {
        a(1), b(2), c(3);

        private int num;

        innerEnum(int num) {
            this.num = num;
            System.out.println("haha");
        }
    }

    public static void main(String[] args) {
        Set<innerEnum> s = new HashSet<>();
        for (innerEnum innerEnum2 : innerEnum.values()) {
            s.add(innerEnum2);
            System.out.println(s.contains(innerEnum2));
        }
        // System.out.println(innerEnum.a);
        // System.out.println(innerEnum.a);
        // System.out.println(innerEnum.a);
        // System.out.println(innerEnum.b);
        // System.out.println(innerEnum.b);
    }
}
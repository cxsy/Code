import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//饿汉式
class Single1 {
    private static final Single1 INSTANCE = new Single1();

    private Single1() {
    }

    public static Single1 getInstance() {
        return INSTANCE;
    }
}

// 懒汉式,线程不安全
class Single2 {
    private static Single2 INSTANCE = null;

    private Single2() {
    }

    public static synchronized Single2 getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Single2();
        }
        return INSTANCE;
    }
}

// 懒汉式,线程安全,多线程环境下效率不高
class Single3 {
    private static Single3 INSTANCE = null;

    private Single3() {
    }

    public static synchronized Single3 getInstance() {
        if (INSTANCE == null) {
            try {
                INSTANCE = new Single3();
            } catch (Exception e) {
            }
        }
        return INSTANCE;
    }
}

// 双重检查加锁
class Single33 {
    private static volatile Single33 INSTANCE = null;

    private Single3() {
    }

    public static Single33 getInstance() {
        if (INSTANCE == null) {
            synchronized (Single33.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Single33(); // 指令重排序

                    // 申请一块内存空间
                    // 在这块空间里实例化对象
                    // instance的引用指向这块空间地址
                }
            }
        }
        return INSTANCE;
    }
}

// 懒汉式,线程安全
class Single4 {
    private static Single4 INSTANCE = null;
    // 同静态变量赋值，静态代码块在类初始化阶段运行
    static {
        INSTANCE = new Single4();
    }

    private Single4() {
    }

    public static Single4 getInstance() {
        return INSTANCE;
    }
}

// 静态内部类,线程安全
class Single5 {
    public final static class SingletonHolder {
        public static final Single5 INSTANCE = new Single5();
    }

    static {
        System.out.println("class Single5 initialized!");
    }

    private Single5() {
    }

    public static Single5 getInstance() {
        return SingletonHolder.INSTANCE;
    }
}

/**
 * Single6
 */
class Single6 {
    private Single6() {
    }

    public static Single6 getInstance() {
        return Singleton.INSTANCE.getInstance();
    }

    private static enum Singleton {
        INSTANCE(new Single6());

        private Single6 instance;

        private Singleton(Single6 ins) {
            instance = ins;
        }

        public Single6 getInstance() {
            return instance;
        }
    }
}

/**
 * Singleton1
 */
public class Singleton {
    public static void main(String[] args) {
        // System.out.println("Hello World!");
        // System.out.println(Single1.getInstance() == Single1.getInstance());
        // System.out.println(Single2.getInstance() == Single2.getInstance());
        // System.out.println(Single3.getInstance() == Single3.getInstance());
        // System.out.println(Single4.getInstance() == Single4.getInstance());
        // System.out.println(Single5.getInstance() == Single5.getInstance());
        System.out.println(Single6.getInstance() == Single6.getInstance());
        // ExecutorService threadPool = Executors.newFixedThreadPool(20);
        // System.out.println(Single5.SingletonHolder.INSTANCE);
        // for (int i = 0; i < 20; i++) {
        // threadPool.execute(new Runnable() {

        // @Override
        // public void run() {
        // System.out.println(Thread.currentThread().getName() + ":" +
        // Single2.getInstance());
        // }
        // });
        // }
        // threadPool.shutdown();
    }
}

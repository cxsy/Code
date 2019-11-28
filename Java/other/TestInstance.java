abstract class Animal {
    private String name;

    Animal(String name) {
        this.name = name;
    }

    public abstract void enjoy();
}

class TICat extends Animal {
    public String eyesColor;

    TICat(String n, String c) {
        super(n);
        eyesColor = c;
    }

    public void enjoy() {
        System.out.println("猫叫声......");
    }
}

class TIDog extends Animal {
    public String furColor;

    TIDog(String n, String c) {
        super(n);
        furColor = c;
    }

    public void enjoy() {
        System.out.println("狗叫声......");
    }
}

/**
 * TestInstance
 */
public class TestInstance {
    public static void main(String[] args) {
        TICat c = new TICat("TICatname", "blue");
        TIDog d = new TIDog("TIDogname", "black");
        print(c);
        print(d);
        // System.out.println(a instanceof Animal);
        // System.out.println(d instanceof Animal);
        // System.out.println(a instanceof TICat);
        // a = new TIDog("bigyellow", "brown");
        // System.out.println(((TIDog) a).furColor);
        // print(c);
        // print(d);
    }

    public static void print(Animal a) {
        a.enjoy();
    }
    // public static void print(Animal a) {
    // System.out.println(a.name);
    // if (a instanceof TICat) {
    // System.out.println(((TICat) a).eyesColor);
    // } else if (a instanceof TIDog) {
    // System.out.println(((TIDog) a).furColor);
    // }
    // }
}
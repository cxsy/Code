/**
 * TestEquals
 */
public class TestEquals {
    public static void main(String[] args) {
        TECat c1 = new TECat(1, 2, 3);
        System.out.println(c1.equals(new TECat(1, 2, 3)));
    }
}

class TECat {
    int color;
    int height, weight;

    public TECat(int color, int height, int weight) {
        this.color = color;
        this.height = height;
        this.weight = weight;
    }

    public boolean equals(Object other) {
        if (other == null || !(other instanceof TECat)) {
            return false;
        }
        TECat c = (TECat) other;
        return this.color == c.color && this.height == c.height && this.weight == c.weight;
    }
}
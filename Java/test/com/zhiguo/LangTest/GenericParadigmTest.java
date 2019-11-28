package com.zhiguo.LangTest;

import java.util.ArrayList;

/**
 * GenericParadigmTest
 */
class M {
}

class N extends M {
}

public class GenericParadigmTest {

    public static void main(String[] args) {
        ArrayList<? extends M> list = new ArrayList();
        list.get(0);
        // list.add(new M());
        ArrayList<? super M> list1 = new ArrayList();
        list1.add(new M());
        list1.add(new N());
    }
}
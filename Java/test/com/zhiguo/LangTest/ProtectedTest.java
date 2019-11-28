package com.zhiguo.LangTest;

/**
 * ProtectedTest
 */
class TT extends Number {
    @Override
    protected Object clone() throws CloneNotSupportedException {
        // TODO Auto-generated method stub
        return super.clone();
    }

    @Override
    public int intValue() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public long longValue() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public double doubleValue() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public byte byteValue() {
        // TODO Auto-generated method stub
        return super.byteValue();
    }

    @Override
    public float floatValue() {
        // TODO Auto-generated method stub
        return 0;
    }
}

public class ProtectedTest {

    public static void main(String[] args) {
        TT t = new TT();
        try {
            TT tt = (TT) t.clone();

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
package com.zhiguo.LangTest;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

class User {
    final Integer a = 1;
    private String sex;
    public String name;
    public Integer age;

    public User() {
    }

    public User(String s, String n, Integer a) {
        this.sex = s;
        this.name = n;
        this.age = a;
    }

    private User(User other) {
        this.sex = other.getSex();
        this.name = other.name;
        this.age = other.age;
    }

    public String getSex() {
        return this.sex;
    }
}

/**
 * ReflectTest
 */
public class ReflectTest {
    static void setFinalStatic(Field field, User u, Object newValue) throws Exception {
        field.setAccessible(true);
        Field modifiersField = Field.class.getDeclaredField("modifiers");
        modifiersField.setAccessible(true);
        modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);
        field.set(u, newValue);
    }

    public static void main(String[] args) {
        try {
            Class uClass = Class.forName("com.zhiguo.LangTest.User");
            System.out.println(uClass.getName());
            System.out.println("======change final static value======");
            User u = new User();
            Field finalValue = uClass.getDeclaredField("a");
            setFinalStatic(finalValue, u, 2);
            // finalValue.set(null, 2);
            System.out.println(u.a);
            System.out.println("======public constructors======");
            Constructor[] constructors = uClass.getConstructors();
            for (Constructor constructor : constructors) {
                System.out.println(constructor);
            }
            System.out.println("======all constructors======");
            Constructor[] allConstructors = uClass.getDeclaredConstructors();
            for (Constructor constructor : allConstructors) {
                System.out.println(constructor);
            }
            System.out.println("======public 无参constructors======");
            Constructor c1 = uClass.getConstructor(null);
            System.out.println(c1);
            System.out.println("======public 有参constructors======");
            Constructor c2 = uClass.getDeclaredConstructor(String.class, String.class, Integer.class);
            System.out.println(c2);
            System.out.println("======private 有参constructors======");
            Constructor c3 = uClass.getDeclaredConstructor(User.class);
            System.out.println(c3);
            System.out.println("======public fields======");
            Field[] fields = uClass.getFields();
            for (Field field : fields) {
                System.out.println(field);
            }
            System.out.println("======all fields======");
            Field[] allFields = uClass.getDeclaredFields();
            for (Field field : allFields) {
                System.out.println(field);
            }
            System.out.println("======获取私有字段并使用======");
            try {
                Field sexField = uClass.getDeclaredField("sex");
                sexField.setAccessible(true);
                Object obj = uClass.getDeclaredConstructor(new Class[] { String.class, String.class, Integer.class })
                        .newInstance("male", "zhiguo", 24);
                sexField.set(obj, "superman");
                System.out.println(((User) obj).getSex());
            } catch (Exception e) {
                // TODO: handle exception
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // String str = "hello";
        // try {
        // Class strClass = Class.forName("java.lang.String");
        // // System.out.println(strClass.getName());
        // System.out.println("===========获取 public构造方法===========");
        // Constructor[] constructors = strClass.getConstructors();
        // for (Constructor constructor : constructors) {
        // System.out.println(constructor);
        // }

        // System.out.println("===========获取 所有构造方法===========");
        // Constructor[] allConstructors = strClass.getDeclaredConstructors();
        // for (Constructor constructor : allConstructors) {
        // System.out.println(constructor);
        // }
        // } catch (Exception e) {
        // // TODO: handle exception
        // }
        // try {
        // Method m = str.getClass().getMethod("toUpperCase");
        // System.out.println(m.invoke(str));
        // } catch (Exception e) {
        // // TODO: handle exception
        // }
        // try {
        // Method[] methods = str.getClass().getMethods();
        // for (Method method : methods) {
        // System.out.println(method);
        // }
        // } catch (Exception e) {
        // // TODO: handle exception
        // }
    }
}
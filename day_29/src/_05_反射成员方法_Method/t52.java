package _05_反射成员方法_Method;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class t52 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class c = Phone.class;
        Constructor constructor = c.getDeclaredConstructor();
        System.out.println(constructor);

        System.out.println("------------------------");
        Constructor constructor1 = c.getDeclaredConstructor(String.class);
        System.out.println(constructor1);

        Object o1 = constructor1.newInstance("华为");
        System.out.println(o1);

        Constructor[] arr = c.getDeclaredConstructors();
        for (Constructor constructor2 : arr) {
            System.out.println(constructor2);
        }
        System.out.println("=====================");

        Object o = c.newInstance();
        System.out.println(o);

    }
}

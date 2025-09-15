package _05_反射成员方法_Method;

import java.lang.reflect.Constructor;

public class t51 {
    public static void main(String[] args) throws Exception{
        Class c = Phone.class;
        Constructor constructor = c.getConstructor();
        System.out.println(constructor);

        Constructor constructor1 = c.getConstructor(String.class);
        System.out.println(constructor1);

        Object o1 = constructor1.newInstance("华为");
        System.out.println(o1);

        Constructor[] arr = c.getConstructors();
        for (Constructor constructor2 : arr) {
            System.out.println(constructor2);
        }

    }
}

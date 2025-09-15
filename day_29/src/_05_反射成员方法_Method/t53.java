package _05_反射成员方法_Method;

import java.lang.reflect.Method;

public class t53 {
    public static void main(String[] args) throws Exception{
        Class c = Phone.class;
        Method[] arr = c.getMethods();
        Method[] arr2 = c.getDeclaredMethods();
        for (Method method : arr) {
            System.out.println(method);
        }
        System.out.println("---------------");
        for (Method method : arr2) {
            System.out.println(arr2);
        }
        System.out.println("===============");

        Method toString = c.getMethod("toString");

        Method tt = c.getDeclaredMethod("tt");

        Object o = c.newInstance();

        Object invoke = toString.invoke(o);
        System.out.println(invoke);
        System.out.println("--------");
        tt.setAccessible(true);
        Object invoke1 = tt.invoke(o);
        System.out.println(invoke1);
    }
}

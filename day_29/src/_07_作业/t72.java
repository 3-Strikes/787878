package _07_作业;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

public class t72 {
    public static void main(String[] args) throws NoSuchMethodException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class c = Student.class;
        Constructor constructor = c.getConstructor();

        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        int age = sc.nextInt();

        Method setName = c.getMethod("setName", String.class);
        Method setAge = c.getMethod("setAge", int.class);


        Object o = c.newInstance();

        Field name1 = c.getDeclaredField("name");
        name1.setAccessible(true);
        name1.set(o,name);
        Field age1 = c.getDeclaredField("age");
        age1.setAccessible(true);
        age1.set(o,age);

        System.out.println(o);
        System.out.println("反射方法设置的姓名是："+name1.get(o));
        System.out.println("反射方法设置的年龄是："+age1.get(o));

    }
}

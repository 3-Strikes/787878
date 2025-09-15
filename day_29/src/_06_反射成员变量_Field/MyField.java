package _06_反射成员变量_Field;

import java.lang.reflect.Field;

/*
    练习反射类中的成员变量,并执行
 */
public class MyField {
    public static void main(String[] args) throws Exception {
        // 1: 获取字节码文件对象
        Class c = Phone.class;
        // 2: 提前准备一个手机对象
        Object o = c.newInstance();
        // 3: 从 c 中获取 指定名称的 成员变量
        Field price = c.getDeclaredField("price");
        System.out.println(price);
        // 4: 获取全部
        Field[] arr = c.getDeclaredFields();
        for (Field field : arr) {
            System.out.println(field);
        }
        System.out.println("---------------");
        // 给 price 变量存值
        price.setAccessible(true);
        price.set(o,888.99);
        System.out.println(o);
        // 获取数据
        System.out.println(price.get(o));
    }
}

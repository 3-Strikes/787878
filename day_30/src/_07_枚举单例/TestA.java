package _07_枚举单例;


import java.lang.reflect.Constructor;

public class TestA {
    public static void main(String[] args) throws  Exception {
        // 使用多线程的方式获取
        Runnable r = ()->{
            String name = Thread.currentThread().getName();
            for (int i = 0; i < 10; i++) {
                System.out.println(name+"获取了:"+ A.A);
            }
        };

        new Thread(r).start();
        new Thread(r).start();
        new Thread(r).start();


        // 使用暴力反射构造方法并执行
        Constructor  constructor =  A.class.getDeclaredConstructor();
        constructor.setAccessible(true);
         Object a = constructor.newInstance();
        System.out.println(a);
    }
}

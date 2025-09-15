package _01_JDK动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
        // 1: 不考虑使用代理,直接面向 目标对象,调用方法
        //Star star = new YCY();
        //star.sing();
        //star.dance();

        // 调用自定义的方法,获取一个代理对象,通过代理对象,调用唱歌或跳舞的方法
        Star proxy = getProxy(new YCY());
        proxy.dance();
        proxy.sing();
        proxy.smail();
    }

    // 自定义一个方法,利用动态代理的技术,根据原始的目标对象,生成一个代理对象,让代理对象,在目标对象执行前,准备场地,收钱;(增强)
    public static Star getProxy(Star star){
        // 1: 可以直接利用 JDK 提供的 工具类 Proxy 的静态方法,直接生成代理对象
        return (Star) Proxy.newProxyInstance(star.getClass().getClassLoader(), star.getClass().getInterfaces(), new InvocationHandler() {
            /*
                invoke 方法的三个参数分别是:
                proxy: 即将产生的代理对象,在这里仅仅是一个占位符而已,不能使用!!!
                method: 目标对象中即将执行的方法
                args: 目标对象中要执行的时候,需要的实际参数
                invoke 方法的返回值,代表的是 目标对象执行后,返回的结果;
             */
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                // 在这里就可以写代理  增强的逻辑
                System.out.println("代理开始准备场地....");
                System.out.println("代理收钱...");
                //  通过 method 让目标对象的方法执行
                Object invoke = method.invoke(star, args);
                System.out.println("代理打扫卫生...");
                return invoke;
            }
        });
    }
}

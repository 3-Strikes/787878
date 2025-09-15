package _03_cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/*
    cglib的动态代理

    固定套路:
    1: 准备环境;(引入jar包)
    2: 创建 核心对象 (Enhancer)
    3: 给核心对象,设置目标对象(指定代理的父类)
    4: 设置回调函数(增强的逻辑)
    5: 面向核心对象,获取代理对象


 */
public class Test {
    public static void main(String[] args) {
        // 2: 创建 核心对象 ()
        Enhancer enhancer = new Enhancer();
        // 3: 给核心对象,设置目标对象(指定代理的父类)
        enhancer.setSuperclass(YCY.class);
        // 4: 设置回调函数(增强的逻辑)
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            /*
                4个参数:
                1: o 是即将生成的代理对象
                2: method 是目标对象(父类)中即将执行的方法方法;
                3: objects 是目标对象的即将执行的方法需要的实际参数;
                4: methodProxy 是 目标对象即将执行的方法的代理对象
             */
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                // 准备场地,收钱
                System.out.println("准备场地,收钱....");
                // 让目标对象的方法执行
                Object o1 = methodProxy.invokeSuper(o, objects);
                return o1;
            }
        });
        // 5: 面向核心对象,获取代理对象
        YCY o = (YCY) enhancer.create();
        o.sing();
        o.dance();
        o.smail();
    }
}

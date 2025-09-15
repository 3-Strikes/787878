package _05_作业_01;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class Test2 {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Teacher.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("上课铃响了");
                Object o1 = methodProxy.invokeSuper(o, objects);//用增强逻辑
                System.out.println("下课铃响了");
                return o1;
            }
        });
        Teacher t = (Teacher) enhancer.create();
        t.teach();

    }

}

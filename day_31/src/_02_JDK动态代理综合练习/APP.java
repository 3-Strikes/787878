package _02_JDK动态代理综合练习;

import java.lang.reflect.Proxy;
import java.util.Arrays;

public class APP {
    public static void main(String[] args) {
        JK jk = getProxy(new UserManager());
        String login = jk.login("张三","123456");
        System.out.println(login);
        jk.delete("张三");
        System.out.println(jk.select());
    }

    private static JK getProxy(JK jk) {
        return (JK)Proxy.newProxyInstance(jk.getClass().getClassLoader(),jk.getClass().getInterfaces(),(proxy, method, args) -> {

            long t1 = System.currentTimeMillis();
            Object invoke = method.invoke(jk, args);
            long t2 = System.currentTimeMillis();

            String name = method.getDeclaringClass().getName();
            String methodName = method.getName();

            System.out.println(name+"类下"+methodName+"方法执行耗时："+(t2-t1)+"，参数为："+(args!=null? Arrays.toString(args):"null")+
                    ",方法执行后返回的结果是："+invoke);

            return invoke;
        });


    }


}

package _08_反射的综合练习;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

/*
    这是我们自定义的工具类

    可以读 src 下的 conf.properties 文件,并根据文件中配置的类和方法,和实参,执行类中对应的方法,并返回方法的结果

    分析:
        1:　读 src 下的 conf.properties 文件；（可以使用类加载器读文件形成一个输入流）
        2:  使用 properties 集合 读取 conf.properties 文件中的3个方面的信息
        3: 利用反射,获取字节码文件对象
        4: 反射成员方法,并执行
        5: 返回结果



 */
public class MyTool {
    private MyTool(){

    }

    public static Object myInvokeMethod() throws Exception {
        //1:　读 src 下的 conf.properties 文件；（可以使用类加载器读文件形成一个输入流）
        InputStream in = MyTool.class.getClassLoader().getResourceAsStream("conf.properties");
        //2:  使用 properties 集合 读取 conf.properties 文件中的3个方面的信息
        Properties p = new Properties();
        p.load(in);
        // 3: 从 p 中获取要执行的类路径
        String className = p.getProperty("className");
        // 根据类路径获取字节码文件对象
        Class c = Class.forName(className);
        // 从p中获取方法名和实参
        String methodName = p.getProperty("methodName");
        String param = p.getProperty("param");
        // 反射对应的方法
        Method method = c.getMethod(methodName, String.class);
        // 让 method 执行
        return method.invoke(c.newInstance(),param);
    }
}

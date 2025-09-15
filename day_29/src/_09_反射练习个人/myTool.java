package _09_反射练习个人;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

public class myTool {
    private myTool(){

    }

    public static Object myInvoke()throws Exception{
        //1 读去src下的conf。properties文件，使用类加载器读文件形成一个输入流
        InputStream resourceAsStream = myTool.class.getClassLoader().getResourceAsStream("conf.properties");
        //2 声明一个Properties类 存取文件中的内容
        Properties p = new Properties();
        p.load(resourceAsStream);

        //3 从p中获取要执行的类路径
        String className = p.getProperty("className");
        //根据类路径获取字节码文件对象
        Class c = Class.forName(className);
        //从p中获取方法名和实参
        String methodName = p.getProperty("methodName");
        String param = p.getProperty("param");
        //反射对应的方法
        Method method = c.getMethod(methodName, String.class);

        return method.invoke(c.newInstance(),param);
    }



}

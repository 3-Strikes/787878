package _10_增强训练.第一题;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class t101 {
    public t101() {
    }

    public static void main(String[] args) throws IOException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        //获取conf.properties文件
        InputStream in = t101.class.getClassLoader().getResourceAsStream("conf.properties");
        Properties p = new Properties();
        p.load(in);

        String className = p.getProperty("className");

        String methodName = p.getProperty("methodName");

//        Class<? extends String> aClass = className.getClass();
        Class clazz = Class.forName(className);

        Method method = clazz.getMethod("eat");

        Object o = clazz.getConstructor().newInstance();

        method.invoke(o);

    }
}

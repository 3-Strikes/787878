package _10_增强训练.第二题;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.Set;

public class t102 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        InputStream in = t102.class.getClassLoader().getResourceAsStream("conf2.properties");
        Properties p = new Properties();
        p.load(in);


        //获取文件信息
        String dataSourceName = p.getProperty("DataSourceName");

        Class clazz = Class.forName(dataSourceName);

        Object o = clazz.getConstructor().newInstance();

        Set<String> propertyNames = p.stringPropertyNames();

        for (String propertyName : propertyNames) {
            String propertyValue = p.getProperty(propertyName);
            if(!"DateSourceName".equals(propertyName)){
                String setMethodName = getSetMethodName(propertyName);
                Method method = clazz.getMethod(setMethodName, String.class);
                method.invoke(o,propertyValue);


            }

        }
        System.out.println(o);

    }
    //定义方法根据成员变量名获取set方法名称
    public static String getSetMethodName(String name) {
        return "set"+name.substring(0,1).toUpperCase()+name.substring(1);
    }
}

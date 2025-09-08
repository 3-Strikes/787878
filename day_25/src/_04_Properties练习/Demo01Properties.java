package _04_Properties练习;

import java.util.Properties;
import java.util.Set;

/*
    java.util.Properties集合是Hashtable的子类,双列集合
        主要使用的是与String相关的方法

    常用方法:
        public  Object setProperty(String k,String v): 保存一个键值对(属性名=属性值)
        public  String getProperty(String key): 根据属性名获取属性值
        public Set<String> stringPropertyNames(): 获取所有属性值对应的Set集合


    java.lang.System类: 与系统相关的工具类
    静态方法:
        public static Properties getProperties(): 获取系统相关的属性名及属性值

 */
public class Demo01Properties {
    public static void main(String[] args) {
        //System类调用静态方法,获取Properties对象
        Properties props = System.getProperties();
        //增强for遍历
//        for (String propertyName : props.stringPropertyNames()) {
//            String propertyValue = props.getProperty(propertyName);
//            System.out.println(propertyName+"::"+propertyValue);
//        }
        method01();
    }
    //Properties集合的基本使用
    private static void method01() {
        Properties props = new Properties();
        //添加键值对
        props.setProperty("name","zhangsan");
        props.setProperty("age","28");
        props.setProperty("gender","nan");

        //遍历
        Set<String> propertyNames = props.stringPropertyNames();
        for (String propertyName : propertyNames) {
            String propertyValue = props.getProperty(propertyName);
            System.out.println(propertyName+"::"+propertyValue);
        }
    }
}

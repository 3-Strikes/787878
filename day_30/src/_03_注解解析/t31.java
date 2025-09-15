package _03_注解解析;

import _02_元注解.MyAnno2;
import org.junit.Test;

import java.lang.reflect.Method;

public class t31 {

    @MyAnno(name = "张三",value = "19",anno2 = @MyAnno2)
    @Test
    public void show() throws NoSuchMethodException {
        //1.声明获取.class文件
        Class t31Class = t31.class;
        //利用 反射获取 成分 目前注解施加在了方法上所以用的是getmethod
        Method method = t31Class.getMethod("show");
        //面对反射获取的对象利用getDelcardAnnotion(要解析的注解)直接获取成分..
        MyAnno annotation = method.getAnnotation(MyAnno.class);
        //进行调用
        System.out.println("注解解析获取的name="+annotation.name()+" value="+annotation.value()+" age="+annotation.age());

    }
}

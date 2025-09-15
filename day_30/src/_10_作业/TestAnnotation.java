package _10_作业;

import org.junit.Test;

import java.lang.reflect.Method;

@MyAnnotation(name = "大狗")
public class TestAnnotation {
    @MyAnnotation(name = "李四",age = 120)
    @Test
    public void show() throws NoSuchMethodException {
        Class c = TestAnnotation.class;
        Method method = c.getMethod("show");
        MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);

        System.out.println("注解name= "+annotation.name()+" age= "+annotation.age());
    }
}

package _06_Junit手写测试;
/*
    自定义的注解类,当某个类的方法头上添加了这个注解的时候,我们就反射这个方法,并执行它
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyTest {
}

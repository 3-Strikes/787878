package _02_元注解;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnno {
    public String name();

    public String value();

    public int age() default 20;

    public Sex sex()default  Sex.Man;

    public MyAnno2 anno2();


}

package _01_注解;

public @interface MyAnno {
    public String name();

    public String value();

    public int age() default 20;

    public Sex sex()default  Sex.Man;

    public MyAnno2 anno2();


}

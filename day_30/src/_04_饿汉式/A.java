package _04_饿汉式;
/*
    单例设计模式的 饿汉式
 */
public class A {
    private A(){
        System.out.println("A创建对象了..."+this);
    }

    private static A a = new A(); // new 对象的过程是 3个动作,  1: 开空间,2: 初始化空间的内容 3: 给变量 a 赋值

    public static A getA(){
        return a;
    }

}

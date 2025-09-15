package _05_懒汉式;
/*
    懒汉式单例

    定义变量的时候,不会直接创建对象,而是等调用方法的时候,才开始创建对象

 */
public class A {
    private A(){

    }
    private volatile static A a ; // 不会立刻创建对象

    public static A getA(){
        if(a == null){
            synchronized (A.class){
                if(a == null){
                    a = new A();
                }
            }
        }
        return a;
    }
}

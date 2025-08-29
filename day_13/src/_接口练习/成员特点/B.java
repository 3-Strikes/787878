package _接口练习.成员特点;

public interface B {
    public default void show1(){
        System.out.println("B接口的默认方法。。。。");
    }
}

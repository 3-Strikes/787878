package _接口练习.成员特点;

public interface C {
    public default void show1(){
        System.out.println("c接口的默认方法。。。");
    }
}

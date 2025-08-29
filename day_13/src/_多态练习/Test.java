package _多态练习;

public class Test {
    public static void main(String[] args) {
        F f = new Z();
        System.out.println(f.a);//编译看父类，运行看父类
        System.out.println(f.c);//编译看父类，运行看父类
        f.show();//编译看父类，运行看子类
        f.show2();//编译看父类，运行看子类
    }
}

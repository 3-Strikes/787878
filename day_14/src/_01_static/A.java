package _01_static;

public class A {
    public static int a = 100;
    int b = 5;

    public static void show(){
//        System.out.println(b);//因为static修饰后 静态方法先在内存中存在 所以无法掉用 非静态的变量b
        System.out.println("此为类中的静态方法");
    }

    public void show(int a){
        System.out.println(this.a);
        System.out.println("此为类中的非静态方法");
    }
}

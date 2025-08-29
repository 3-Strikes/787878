package _01_static;

public class Test1 {
    public static void main(String[] args) {
        System.out.println(A.a);
        A.show();

        A a1 = new A();
        A a2 = new A();
        System.out.println(a1.a);
        System.out.println(a2.a);
        a1.a = 200;
        System.out.println(a2.a);
    }

}

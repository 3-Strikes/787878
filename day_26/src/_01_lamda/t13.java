package _01_lamda;

public class t13 {
    public static void main(String[] args) {
        m1(()->{
            System.out.println("lambda.....");
        });

        A a = ()->{
            System.out.println("直接给接口赋值的lamdbda...");
        };

        a.av();
    }

    public static void m1(A a){
        a.av();
    }
}

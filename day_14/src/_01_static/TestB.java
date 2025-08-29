package _01_static;

public class TestB {
    public static void main(String[] args) {
        opF(new B(){

            @Override
            public void fly() {
                System.out.println("匿名内部类的fly方法。。。");
            }
        });

        System.out.println("mian方法结束了...");
    }

    public static void opF(B b){
        b.fly();
        System.out.println("自定义的方法执行了....");
    }
}

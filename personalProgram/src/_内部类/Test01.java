package _内部类;

interface Greeting{
    void sayHello();
}
public class Test01 {
    public static void main(String[] args) {
        Greeting greeting = new Greeting() {
            @Override
            public void sayHello() {
                System.out.println("hello,匿名内部类！！");
            }
        };
        greeting.sayHello();
    }
}

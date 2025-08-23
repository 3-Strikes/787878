package _01_继承练习;

public class Zi extends Fu{
    public Zi() {
        System.out.println("子类的空参数构造方法执行了...");
    }

    public Zi(String name, int age, String birthday) {
        super(name, age, birthday);
        System.out.println("子类的带参数构造方法执行了...");
    }

    public void a(){
        System.out.println("子类的a方法执行了");
        this.b();
    }

    public void b(){
        System.out.println("子类的b方法执行了...");
    }
}

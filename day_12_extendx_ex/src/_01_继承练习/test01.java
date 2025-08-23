package _01_继承练习;

public class test01 {
    public static void main(String[] args) {
        Zi1 z1 = new Zi1("zhangsan",12,"2002");
        System.out.println(z1+z1.show1());
        Zi z3 = new Zi();
        Zi z2 = new Zi("zhangsan",12,"2002");
        System.out.println(z2);
        z3.a();
        System.out.println(z3);
    }


}

class Zi1 extends Fu{
    public Zi1(String name, int age, String birthday) {
        super(name, age, birthday);
    }
}

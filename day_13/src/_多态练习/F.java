package _多态练习;

public class F {
    public int a = 10;
    public int c = 10;
    public void show(){
        System.out.println("父类的show方法，a"+a);
    }
    public void show2(){
        System.out.println("父类的show2方法，c"+c);
    }

    private void show3(){
        System.out.println("父类特有show3方法");
    }
}

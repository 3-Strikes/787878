package _多态练习;

public class Pig extends Animal{
    public Pig(String name, int age) {
        super(name, age);
    }
    public void eat(){
        System.out.println(getName()+"吃吃吃");
    }
}

package _多态练习;

public class Dog extends Animal{
    public Dog(String name, int age) {
        super(name, age);
    }
    public void eat(){
        System.out.println(getName()+"吃吃吃");
    }
}

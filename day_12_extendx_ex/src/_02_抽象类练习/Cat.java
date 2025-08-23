package _02_抽象类练习;

public class Cat extends Animal{
    public Cat() {
    }

    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println(getAge()+"岁的"+getName()+"正在吃饭");
    }

    @Override
    public void drink() {
        System.out.println(getAge()+"岁的"+getName()+"正在喝水");
    }
}

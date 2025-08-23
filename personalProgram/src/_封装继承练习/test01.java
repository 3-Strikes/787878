package _封装继承练习;

public class test01 {
    public static void main(String[] args) {
        Dog dog = new Dog("旺财",3);

        System.out.println("狗的名字："+dog.name);
        System.out.println("狗的年龄："+dog.age);

        dog.eat();
        dog.makeSound();
        dog.wagTail();

        Cat cat = new Cat("咪咪",2);
        System.out.println("猫的名字："+cat.name);
        System.out.println("猫的年龄:"+cat.age);
        cat.eat();
        cat.makeSound();
        cat.lickFur();


    }
}


abstract class Animal{
    String name;
    int age;
    public Animal(String name,int age){
        this.name = name;
        this.age = age;
    }

    public void eat(){
        System.out.println(age+"岁的"+name+"在吃东西");
    }

    public abstract void makeSound();
}

class Dog extends Animal{
    public Dog(String name,int age){
        super(name, age);
    }

    @Override
    public void makeSound(){
        System.out.println(age+"岁的"+name+"在汪汪叫~~~~");
    }

    public void wagTail(){
        System.out.println(name+"开心地摇尾巴！ ");
    }
}

class Cat extends Animal{
    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound(){
        System.out.println(age+"岁的"+name+"在喵喵叫~~~");
    }

    public void lickFur(){
        System.out.println(name+"在优雅的舔毛！ ");
    }
}
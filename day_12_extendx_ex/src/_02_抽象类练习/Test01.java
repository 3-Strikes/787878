package _02_抽象类练习;

public class Test01 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();

        dog.eat();
        dog.drink();

        cat.eat();
        cat.drink();

        Dog dog1 = new Dog("垃圾",10);
        Cat cat1 = new Cat("黑咪",2);

        dog1.eat();
        dog1.drink();

        cat1.eat();
        cat1.drink();
    }
}

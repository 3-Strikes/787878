package _03_zuoye._code2;

public class Test2 {
    public static void main(String[] args) {
        Animal[] animals = new Animal[4];
        animals[0] = new Dog("旺财","狗");
        animals[1] = new Dog("小白","狗");
        animals[2] = new Cat("咪咪","猫");
        animals[3] = new Animal() {
            private String name = "小翠";
            private String type = "鸟";

            @Override
            public void makeSound() {
                System.out.println("叽叽喳喳");
            }

            @Override
            public String getType() {
                return type;
            }
        };

        int dogCount = 0;
        int catCount = 0 ;
        int birdCount = 0;

        for (Animal animal:animals){
            switch (animal.getType()){
                case "狗":
                    dogCount++;
                    break;
                case "猫":
                    catCount++;
                    break;
                case "鸟":
                    birdCount++;
                    break;
            }
        }

        System.out.println("动物列表：");
        for (Animal animal:animals){
            System.out.println(animal.toString());
        }

        System.out.println("动物叫声展示：");
        for (Animal animal:animals){
            animal.makeSound();
        }

        System.out.println("动物类型统计：");
        System.out.println("狗："+dogCount);
        System.out.println("猫："+catCount);
        System.out.println("鸟:"+birdCount);

        Dog dog1 = new Dog("旺财","狗");
        Dog dog2 = new Dog("旺财","狗");

        Cat cat1 = new Cat("小白","猫");
        System.out.println(dog1.equals(dog2));
        System.out.println(dog1.equals(cat1));


    }
}

package _10_作业;

import java.lang.reflect.InvocationTargetException;

public class TestCar {
    public static void main(String[] args) throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Car car1 = (Car) CarFactory.createCar("_10_作业.BenzCar");
        Car car2 = (Car) CarFactory.createCar("_10_作业.ToyotaCar");

        car1.run();
        car2.run();
    }
}

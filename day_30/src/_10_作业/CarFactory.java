package _10_作业;

import java.lang.reflect.InvocationTargetException;

public class CarFactory {
    public static Object createCar(String type) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        Class c = Class.forName(type);
        return c.getConstructor().newInstance();
    }
}

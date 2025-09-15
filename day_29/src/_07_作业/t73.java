package _07_作业;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class t73 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<String> list = new ArrayList<>();
        list.add("123");
        System.out.println("原生list内容为："+list);


        Class listClass = list.getClass();

        Method method = listClass.getMethod("add", Object.class);
        method.invoke(list,456);

        System.out.println("反射添加后list内容为："+list);
        for (Object o : list) {
            System.out.println(o.getClass().getSimpleName());
        }


    }
}

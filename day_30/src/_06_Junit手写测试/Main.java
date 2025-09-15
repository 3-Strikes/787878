package _06_Junit手写测试;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/*
    找 A 类中的那些方法的头上有 @MyTest 注解,谁有,让谁执行
 */
public class Main {
    public static void main(String[] args)  throws Exception {
        // 1: 获取 A 的字节码文件
        Class<A> c = A.class;
        A a = c.newInstance();
        // 2: 获取所有的方法
        Method[] arr = c.getMethods();
        // 3: 遍历这些方法对象,看谁的头上有  @MyTest 注解,谁有,让谁执行
        /*for (Method method : arr) {
            if(method.isAnnotationPresent(MyTest.class)){
                // 可以执行
                method.invoke(a);
            }
        }*/
        // 使用Stream
        Arrays.stream(arr).filter(m->m.isAnnotationPresent(MyTest.class)).forEach(m->{
            try {
                m.invoke(a);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        });
    }
}

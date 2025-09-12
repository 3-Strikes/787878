package _01_lamda;

import java.util.function.Consumer;

public class t11 {
    public static void main(String[] args) {
        m2(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer){
                System.out.println("消费者把:"+integer+"消费掉了");
            }
        },888);
    }

    public static <T> void m2(Consumer<T> c, T t){
        c.accept(t);
    }

}

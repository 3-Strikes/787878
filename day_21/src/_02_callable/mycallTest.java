package _02_callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class mycallTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Mycall callable = new Mycall();
        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        System.out.println("main方法执行！！！");
        new Thread(futureTask).start();
//        Integer reult = futureTask.get();
        System.out.println("1-100的和为：");

        System.out.println("main结束");


    }

}

package _02_callable;

import java.util.concurrent.Callable;

public class Mycall implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            sum+=i;
            System.out.println(sum);
        }
        Thread.sleep(5000);
        return sum;
    }
}

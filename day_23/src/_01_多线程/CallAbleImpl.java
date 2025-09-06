package _01_多线程;

import java.util.concurrent.Callable;

public class CallAbleImpl implements Callable<Integer> {
    private Integer i ;

    public CallAbleImpl(int i) {
        this.i = i;
    }

    @Override
    public Integer call() throws Exception {
        String name = Thread.currentThread().getName();
        System.out.println(name+"正在运行...");
        return i*i;
    }
}

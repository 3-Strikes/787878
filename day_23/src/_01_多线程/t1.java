package _01_多线程;

import java.util.concurrent.*;

public class t1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor poolExecutor =new ThreadPoolExecutor(
                3,
                10,
                1,
                TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(15),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );
        System.out.println(poolExecutor);

        Runnable r =new Runnable() {
            @Override
            public void run() {
                String name = Thread.currentThread().getName();
                try {
                    Thread.sleep(100);
                }catch (InterruptedException e){
                    throw new RuntimeException(e);
                }
                System.out.println(name+"执行任务完成了");
            }
        };//不带返回值的线程方法

//        //当线程数 超过 核心线程数+队列容量时 临时线程开始启动
//        for (int i = 0; i < 16; i++) {
//            poolExecutor.execute(r);//提交不带返回值的方法
//        }
//        poolExecutor.shutdown();


        //当线程数 超过 队列容量+池子线程最大容量后 开始执行拒绝策略
//        for (int i = 0; i < 26; i++) {
//            poolExecutor.execute(r);
//        }
//        poolExecutor.shutdown();

        for (int i = 1; i <= 25; i++) {
            Callable<Integer> call = new CallAbleImpl(i);
            Future<Integer> submit = poolExecutor.submit(call);
//            Integer i1 = submit.get();
//            System.out.println(i+"的平方="+i1);
        }
        System.out.println(poolExecutor);
        poolExecutor.shutdown();
    }
}

package _04_作业;

import java.util.concurrent.*;

public class zuoye1 {
    static class RangeSumCalculator implements Callable<Integer>{
        private int start;
        private int end;

        public RangeSumCalculator(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public Integer call() throws Exception {
            int sum = 0;
            for (int i = start;i<=end;i++){
                sum+=i;
            }
            return sum;
        }
    }
    public static void main(String[] args) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                2,
                3,
                1,
                TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(5),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        try {
            Future<Integer> future1 = pool.submit(new RangeSumCalculator(0,100));
            Future<Integer> future2 = pool.submit(new RangeSumCalculator(101,200));
            Future<Integer> future3 = pool.submit(new RangeSumCalculator(201,300));

            System.out.println(future1.get());
            System.out.println(future2.get());
            System.out.println(future3.get());
        }catch (InterruptedException e){
            e.printStackTrace();
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } finally {
            pool.shutdown();
        }

    }
}

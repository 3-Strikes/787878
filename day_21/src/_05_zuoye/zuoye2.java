package _05_zuoye;

import java.util.concurrent.ArrayBlockingQueue;

public class zuoye2 {
    public static int producedCount = 0;
    public static final int MAX_PRODUCTS = 5;
    public static void main(String[] args) {
        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(1);


        Thread factory = new Thread(new Runnable() {
            @Override
            public void run() {
                String name = Thread.currentThread().getName();
                try {
                    while (producedCount < MAX_PRODUCTS) {
                        String product = "零件" + (producedCount + 1);
                        arrayBlockingQueue.put(product);
                        producedCount++;
                        System.out.println(name + "放入了一个零件" + product);
                        Thread.sleep(1000);
                    }
                    System.out.println("工厂已完成全部"+MAX_PRODUCTS+"个零件");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println(name+"被中断");
                }
            }
        },"工厂");

        Thread worker = new Thread(new Runnable() {
            @Override
            public void run() {
                String name = Thread.currentThread().getName();
                try {
                    int consumCount = 0;
                    while(consumCount<MAX_PRODUCTS){
                        String product = arrayBlockingQueue.take();
                        consumCount++;
                        System.out.println(name+"加工了"+product+"个零件");
                        Thread.sleep(1000);
                    }
                    System.out.println("工人已完成全部"+MAX_PRODUCTS+"个零件");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println(name+"被中断");
                }
            }
        },"工人");


        factory.start();
        worker.start();
    }
}

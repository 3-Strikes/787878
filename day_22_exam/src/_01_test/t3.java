package _01_test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

public class t3 {
    public static void main(String[] args) {
        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(1);
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                String name = Thread.currentThread().getName();
                int count1 = 10;
                try {
                    while(count1 > 0){
                        int q = random.nextInt(0,6);
                        list.add(q);
                        arrayBlockingQueue.put(String.valueOf(q));
                        count1--;
                        System.out.println("集合中的数据为："+list);
                        Thread.sleep(1000);
                    }
                }catch (InterruptedException e){
                    Thread.currentThread().interrupt();
                    System.out.println(name+"被中断");
                }
            }
        },"线程1");

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                String name = Thread.currentThread().getName();
                HashMap<Integer,Integer> hashMap = new HashMap<>();
                int count2 = 10;
                try {
                    while(count2 > 0){
                        int q = Integer.parseInt(arrayBlockingQueue.take());
                        count2--;
                        int value = hashMap.getOrDefault(q,0);
                        hashMap.put(q,++value);
                        System.out.println("集合中的数据出现的次数："+hashMap);
                        Thread.sleep(1000);
                    }
                }catch (InterruptedException e){
                    Thread.currentThread().interrupt();
                    System.out.println(name+"被中断");
                }
            }
        },"线程2");


        thread1.start();
        thread2.start();
    }
}

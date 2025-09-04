package _04_lock练习;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Tricket implements Runnable{

    private int hao =100;

    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        while (true){
            lock.lock();
            try {
                if(hao>=1){
                    System.out.println(name+"卖出了："+hao+"票---");
                    hao--;
                }else {
                    break;
                }
            }finally {
                lock.unlock();
            }

        }
        System.out.println(name+"窗口关闭了...");
    }
}

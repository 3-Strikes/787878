package _05_zuoye;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Tricket implements Runnable{
    private int hao = 100;
    private Lock lock = new ReentrantLock();
    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        while(true){
            try{
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try{
                lock.lock();
                if(hao>0){
                    System.out.println(name+"号窗口，售出了："+hao+"票...");
                    hao--;
                }else {
                    System.out.println(name+"号窗口，票以售空！");
                    break;
                }
            }finally{
                lock.unlock();
            }


        }
    }
}

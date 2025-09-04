package _03_线程安全;

public class Tricket implements Runnable{

    private int hao =100;

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        while (true){
            synchronized (this){
                if(hao>0){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(name+"卖出了:"+hao);

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    hao--;
                }else {
                    break;
                }
            }
        }
        System.out.println(name+"窗口关闭了...");
    }
}

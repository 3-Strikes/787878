package _01_thread;

public class Myrun implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("run线程运行"+i+"次");
        }
    }
}

package _05_懒汉式;

public class Test {
    public static void main(String[] args) {
        // 使用多线程的方式获取
        Runnable r = ()->{
            String name = Thread.currentThread().getName();
            for (int i = 0; i < 10; i++) {
                System.out.println(name+"获取了:"+ A.getA());
            }
        };

        new Thread(r).start();
        new Thread(r).start();
        new Thread(r).start();
    }
}

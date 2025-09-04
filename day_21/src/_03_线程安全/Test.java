package _03_线程安全;

public class Test {
    public static void main(String[] args) {
        Tricket tricket1 = new Tricket();

        Thread thread1 = new Thread(tricket1);
        Thread thread2 = new Thread(tricket1);
        Thread thread3 = new Thread(tricket1);

        thread1.start();
        thread2.start();
        thread3.start();

    }
}

package _04_lock练习;

import _03_线程安全.Tricket;

public class TestLock {
    public static void main(String[] args) {
        _03_线程安全.Tricket tricket1 = new Tricket();

        Thread thread1 = new Thread(tricket1,"1");
        Thread thread2 = new Thread(tricket1,"2");
        Thread thread3 = new Thread(tricket1,"3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

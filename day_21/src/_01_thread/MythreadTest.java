package _01_thread;

public class MythreadTest {
    public static void main(String[] args) {
        Myrun myrun = new Myrun();

        Thread thread1 = new Thread(myrun);

        thread1.start();

        for (int i = 0; i < 10; i++) {
            System.out.println("main...."+i);
        }

    }
}

package _05_zuoye;

public class zuoye1 {
    public static void main(String[] args) {
        Tricket tricket = new Tricket();

        Thread thread1 = new Thread(tricket,"1");
        Thread thread2 = new Thread(tricket,"2");
        Thread thread3 = new Thread(tricket,"3");

        thread1.start();
        thread2.start();
        thread3.start();


    }
}

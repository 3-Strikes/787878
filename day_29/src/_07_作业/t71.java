package _07_作业;

public class t71 {
    public static void main(String[] args) {
        Week[] week = Week.values();
        for (Week week1 : week) {
            System.out.println(week1+" "+week1.ordinal());
        }
    }
}

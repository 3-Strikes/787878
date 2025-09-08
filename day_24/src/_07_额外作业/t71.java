package _07_额外作业;

import java.util.Scanner;

public class t71 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int month = sc.nextInt();
        System.out.println(getCount(month));
    }

    public static int getCount(int month){
        if(month==1||month==2){
            return 1;
        }else {
            return getCount(month-1)+getCount(month-2);
        }
    }
}

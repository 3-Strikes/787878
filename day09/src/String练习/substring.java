package String练习;

import java.util.Scanner;

public class substring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        System.out.println("请输入手机号为");
        String s1 = s.substring(0,3);
        String s2 = s.substring(7);
        System.out.println(s1+"****"+s2);

        String[] arr = s.split("\\.");
        System.out.println(arr.length);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(">>>"+arr[i]+"<<<");
        }
    }
}

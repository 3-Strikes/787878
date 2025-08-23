package zuoye;

import java.util.Scanner;

public class answer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        method1(s);
    }

    public static void method1(String s){
        int count = 0;
        StringBuilder sbd = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c>='0'&&c<='9'){
                count++;
                sbd.append(c);
            }
        }
        System.out.println(sbd.toString());
    }

}

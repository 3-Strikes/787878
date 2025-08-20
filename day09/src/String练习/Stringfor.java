package String练习;

import java.util.Scanner;

public class Stringfor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        method1(s);
//        char[] arr = s.toCharArray();
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            System.out.println(c);
//        }
    }

    public static void method1(String s){
        int countd = 0,countx = 0,conunts = 0;
        String da ="",xiao="";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c>='A'&&c<='Z'){
                countd++;
                da+=c;
            }
            if(c>='a'&&c<='z'){
                countx++;
                xiao+=c;
            }
        }
        System.out.println(da+xiao);
    }
}

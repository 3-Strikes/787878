package String练习;

public class MyString {
    public static void main(String[] args) {
        String s1 = "abc";
        System.out.println(s1);
        String s2 = new String(new char[]{'你','我','t'});
        System.out.println(s2);
        String s3 = new String("aaa");
        String s3_2 = new String("aaa");
        System.out.println("========================");
        System.out.println(s3);
        System.out.println(s3_2);
        System.out.println(s3==s3_2);
        System.out.println("=========================");

        String s4 = "abc";
        String s5 = "abc";
        System.out.println(s4);
        System.out.println(s5);
        System.out.println(s4==s5);
    }
}

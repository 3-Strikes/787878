package String练习;

public class test01 {
    public static void main(String[] args) {
        StringBuilder sbd = new StringBuilder();
        System.out.println(sbd.length());

        sbd.append(123);
        sbd.append(true);
        sbd.append('H');
        sbd.append("嘿嘿");
        sbd.append(5.5);
        System.out.println(sbd);

        sbd.reverse();

        System.out.println(sbd);


    }
}

package String练习;

public class test02 {
    public static void main(String[] args) {
        StringBuilder sbd = new StringBuilder();
        System.out.println(sbd.length());

        sbd.append(213213213).append("swiduawoidu").append("alskdjasolidjawe").append("！！！！！！！！！");
        System.out.println(sbd);

        sbd.reverse();
        String c = sbd.toString();
        int q = c.toUpperCase().substring(9,20).length();

        System.out.println(q);
        System.out.println(c);


    }
}

package _02_Zuoye.code1;

import java.text.SimpleDateFormat;
import java.util.Date;

public class zuoye {
    public static void main(String[] args) {
        Date time = new Date();
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(format1.format(time));

    }
}

package _01_Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDate {
    public static void main(String[] args) throws ParseException {
        Date date =new Date();
        System.out.println(date);
        Date date1 = new Date(0L);
        System.out.println(date1);

        System.out.println(date.toString());

        date1.setTime(-55555555L);
        System.out.println(date1);
        System.out.println(date.getTime());
        System.out.println(System.currentTimeMillis());
        System.out.println(date.toLocaleString());

        SimpleDateFormat simpleDateFormat =new SimpleDateFormat();
        SimpleDateFormat simpleDateFormat1 =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E");
        System.out.println(simpleDateFormat1.format(date));//日期对象转字符串 格式化

        System.out.println(simpleDateFormat.format(date));

        String s = "2025-08-27 10:22:43 周三";
        //字符串转日期对象 解析
        Date perse =simpleDateFormat1.parse(s);
        System.out.println(perse);



    }
}

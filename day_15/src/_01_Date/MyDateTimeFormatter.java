package _01_Date;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MyDateTimeFormatter {
    public static void main(String[] args) throws ParseException {
        LocalDateTime now = LocalDateTime.now();
        //2: 按自己制定的格式 进行格式化
        //2.1: 获取一个格式化的工具类对象

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss E");
        //2.2 面向日期对象 掉用dateTimeFormatter 方法 传递工具对象即可
        String format = now.format(dateTimeFormatter);//使用日期调用方法，传递工具
        System.out.println(format);

        String format1 = dateTimeFormatter.format(now);//使用工具调用方法，床底日期
        System.out.println(format1);
        //解析
        String s = "1998-11-11 10:03:22 周三";
        LocalDateTime parse = LocalDateTime.parse(s,dateTimeFormatter);
        System.out.println(parse);

    }
}

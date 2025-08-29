package _考试.code3;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
/*
2023/01/01 00:00
2024/01/01 00:00
2025/01/01 00:00
 */
public class Test3 {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        System.out.println("用户输入的 3 个日期时间字符串（格式为 `\"yyyy/MM/dd HH:mm\"`）");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
        String[] ss = new String[3];
        ss[0] = sc.nextLine();
        ss[1] = sc.nextLine();
        ss[2] = sc.nextLine();
        LocalDateTime[] ldts = new LocalDateTime[3];
        for (int i = 0; i < ldts.length; i++) {
            ldts[i] = LocalDateTime.parse(ss[i],dateTimeFormatter);
            System.out.println(ldts[i]);
        }
        LocalDateTime early = LocalDateTime.of(9999,01,01,00,00);
        LocalDateTime latest = LocalDateTime.of(1970,01,01,00,00);
        int earlycount = 9 , latestcount = 10;
        for (int i = 0; i < ldts.length; i++) {
            if(ldts[i].isBefore(early)){
                early = ldts[i];
                earlycount = i;
            }
            if(ldts[i].isAfter(latest)){
                latest = ldts[i];
                latestcount = i;
            }
        }
        System.out.printf("最早时间为：%s",early);
        System.out.println();
        System.out.printf("最晚时间为：%s",latest);
        System.out.println();

//        System.out.println(ldts[earlycount]);
//        System.out.println(ldts[latestcount]);
        long earlyYear = ldts[earlycount].getYear();
        long earlyMonth = ldts[earlycount].getMonthValue();
        long earlyDay = ldts[earlycount].getDayOfMonth();
        long earlyHour = ldts[earlycount].getHour();

        long latestYear = ldts[latestcount].getYear();
        long latestMonth = ldts[latestcount].getMonthValue();
        long latestDay = ldts[latestcount].getDayOfMonth();
        long latestHour = ldts[latestcount].getHour();
//        System.out.println((latestYear-earlyYear));
//        System.out.println((latestMonth-earlyMonth));
//        System.out.println((latestDay-earlyDay));
//        System.out.println(latestHour-earlyHour);
        System.out.println("相差多少小时："+((latestYear-earlyYear)*365*24+(latestMonth-earlyMonth)*30*24+(latestDay-earlyDay)*24+(latestHour-earlyHour)));

    }
}

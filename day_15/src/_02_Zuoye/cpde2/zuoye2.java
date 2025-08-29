package _02_Zuoye.cpde2;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class zuoye2 {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        System.out.println("日期转换，yyyy-MM-dd是星期几");
        System.out.println("输入q退出");

        while(sc.hasNext()){
            String s = sc.next();
            if(s.equals("q")){
                break;
            }
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate date = LocalDate.parse(s,formatter);
            int dayOfWeek = date.getDayOfMonth();
            String weekDay = getWeekDayName(dayOfWeek);
            System.out.printf("%s 是%s%n",s,weekDay);
            DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");
            LocalDateTime localDateTime = LocalDateTime.parse(s,formatter1);
        }
    }

    private static String getWeekDayName(int dayOfWeek) {
        switch (dayOfWeek){
            case 1 : return "星期一";
            case 2 : return "星期二";
            case 3 : return "星期三";
            case 4 : return "星期四";
            case 5 : return "星期五";
            case 6 : return "星期六";
            case 7 : return "星期七";
            default:return "";
        }
    }
}

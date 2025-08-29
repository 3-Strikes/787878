package _01_Date;

import java.time.LocalDateTime;

public class MyLDT {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        LocalDateTime time = LocalDateTime.of(2002,2,4,12,3,4,5);
        System.out.println(time);

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime nowplus7day = now.plusDays(7);
        LocalDateTime nowplus7year =now.plusYears(7);
        System.out.println(nowplus7year);
        System.out.println(nowplus7day);
        System.out.println(nowplus7year.isBefore(nowplus7year));
        LocalDateTime nowplus7mouth = now.plusMonths(7);

        LocalDateTime nowwithday = now.withDayOfMonth(11);
        System.out.println(nowwithday);
        LocalDateTime nowwithmonth = now.withMonth(10);
        System.out.println(nowwithmonth);

    }
}

package _01_Date;

import java.time.LocalDate;
import java.time.Period;

public class MyPeriod {
    public static void main(String[] args) {
        LocalDate date  = LocalDate.of(2002,03,27);
        LocalDate now  = LocalDate.of(2025,8,27);

        Period period = Period.between(date,now);
        int years = period.getYears();
        int months = period.getMonths();
        int days = period.getDays();
        System.out.println("相差："+years+"年"+months+"月"+days+"日");
        long totalmonths = period.toTotalMonths();
        System.out.println(totalmonths);

    }
}

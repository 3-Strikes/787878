package _01_Date;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class MyZone {
    public static void main(String[] args) {
        ZonedDateTime now =ZonedDateTime.now();
        ZonedDateTime now2 =ZonedDateTime.now(ZoneId.of("America/New_York"));
        System.out.println(now);
        System.out.println(now2);
        ZonedDateTime dateTime = now2.plusDays(3);
        System.out.println(dateTime);
    }
}

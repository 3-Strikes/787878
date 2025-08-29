package _考试.code2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Test {
    public static void main(String[] args) {
        Order order = new Order("001",50.00, LocalDateTime.now());
        System.out.println("订单创建的时间为");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(order.formatCreateTime(dateTimeFormatter));
        Order order1 = new Order("002",100.00,LocalDateTime.of(2002,03,27,10,20,5
        ));
        System.out.println(order1.isCreatedBefore(order));
        System.out.println(order.getCreateTimeAfterHours(8));
    }
}

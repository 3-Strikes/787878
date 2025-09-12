package _03_作业;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class t33 {
    public static void main(String[] args) {
        List<Order> orderList = new ArrayList<>();
        orderList.add(new Order("zhangsan1",10001,66.6,1, LocalDateTime.now()));
        orderList.add(new Order("zhangsan2",10002,213123.2,2, LocalDateTime.now()));
        orderList.add(new Order("zhangsan3",10003,5473.3,3, LocalDateTime.now()));
        orderList.add(new Order("zhangsan4",10004,213.324,4, LocalDateTime.now()));
        orderList.add(new Order("zhangsan5",10005,8797897.12,5, LocalDateTime.now()));
        orderList.add(new Order("zhangsan6",10006,877.12,2, LocalDateTime.now()));
        DateTimeFormatter dft = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Map<String,OrderSummary> map = orderList.stream().filter(order -> order.getStats()==2&&order.getPrice()>100)
                .map(order -> {
                    String customeIdStr = String.valueOf(order.getUserId());
                    String paytime = order.getLocalDateTime().format(dft);
                    return new OrderSummary(order.getID(),customeIdStr, order.getPrice(),paytime);
                }).collect(Collectors.toMap(OrderSummary::getID,s->s));
//order -> new OrderSummary(order.getID(),String.valueOf(order.getUserId()),order.getPrice(), order.getLocalDateTime()

        System.out.println("处理后的订单摘要：");
        map.forEach((id,summery)-> System.out.println(summery));
    }
}

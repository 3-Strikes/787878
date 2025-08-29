package _考试.code2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Order {
    private String orderId;
    private double totalAmount;
    private LocalDateTime createTime;

    public Order() {
    }

    public Order(String orderId, double totalAmount, LocalDateTime createTime) {
        this.orderId = orderId;
        this.totalAmount = totalAmount;
        this.createTime = createTime;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String formatCreateTime(DateTimeFormatter dateTimeFormatter){
        String s = dateTimeFormatter.format(createTime);
        return s;
    }

    public boolean isCreatedBefore(Order other){
        LocalDateTime ldt = LocalDateTime.now();
        return ldt.isAfter(other.getCreateTime());
    }

    public LocalDateTime getCreateTimeAfterHours(int hours){
        LocalDateTime ldt = LocalDateTime.now();
        return ldt.plusHours(hours);
    }
}

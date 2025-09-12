package _03_作业;

public class OrderSummary {
    private String ID;
    private String userId;
    private double price;

    private String payTime;

    public OrderSummary(String ID, String userId, double price, String payTime) {
        this.ID = ID;
        this.userId = userId;
        this.price = price;
        this.payTime = payTime;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    @Override
    public String toString() {
        return "OrderSummary{" +
                "ID='" + ID + '\'' +
                ", userId='" + userId + '\'' +
                ", price=" + price +
                ", payTime=" + payTime +
                '}';
    }


}

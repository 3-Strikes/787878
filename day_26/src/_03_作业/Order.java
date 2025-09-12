package _03_作业;

import java.time.LocalDateTime;
import java.util.Objects;

public class Order {
    private String ID;
    private int userId;
    private double price;
    private int stats;
    private LocalDateTime localDateTime;

    public Order(String ID, int userId, double price, int stats, LocalDateTime localDateTime) {
        this.ID = ID;
        this.userId = userId;
        this.price = price;
        this.stats = stats;
        this.localDateTime = localDateTime;
    }

    public Order() {
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStats() {
        return stats;
    }

    public void setStats(int stats) {
        this.stats = stats;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (userId != order.userId) return false;
        if (Double.compare(price, order.price) != 0) return false;
        if (stats != order.stats) return false;
        if (!Objects.equals(ID, order.ID)) return false;
        return Objects.equals(localDateTime, order.localDateTime);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = ID != null ? ID.hashCode() : 0;
        result = 31 * result + userId;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + stats;
        result = 31 * result + (localDateTime != null ? localDateTime.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "ID='" + ID + '\'' +
                ", userId=" + userId +
                ", price=" + price +
                ", stats=" + stats +
                ", localDateTime=" + localDateTime +
                '}';
    }
}

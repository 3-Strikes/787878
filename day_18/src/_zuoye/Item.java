package _zuoye;

public class Item {
    private String id;
    private String name;
    private double price;
    private int stockQuantity;

    public Item(String id, String name, double price, int stockQuantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    public Item() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    @Override
    public String toString() {
        return "Items{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", stockQuantity='" + stockQuantity + '\'' +
                '}';
    }

    @Override
    public Item clone(){
        try {
            return (Item) super.clone();
        }catch (CloneNotSupportedException e){
            return new Item(this.id,this.name,this.price,this.stockQuantity);
        }
    }


}

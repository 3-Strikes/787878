package _05_反射成员方法_Method;

public class Phone {
    private String brand;

    public Phone() {
    }

    public Phone(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "brand='" + brand + '\'' +
                '}';
    }

    private void tt(){
        System.out.println("这是一个测试方法。。。。。");
    }
}

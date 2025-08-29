package _作业._代码题1;

public abstract class OfficeDevice {
    private String id;

    private String brand;

    public OfficeDevice(String id, String brand) {
        this.id = id;
        this.brand = brand;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public abstract void start();
}

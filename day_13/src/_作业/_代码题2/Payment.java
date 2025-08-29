package _作业._代码题2;

public abstract class Payment {
    private String id;
    private String amount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Payment(String id, String amount) {
        this.id = id;
        this.amount = amount;

    }

    public abstract void pay();
}

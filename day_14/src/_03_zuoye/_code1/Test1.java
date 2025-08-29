package _03_zuoye._code1;

public abstract class Test1 {
    public static void main(String[] args) {
        DiscountCalculator fullCount =new DiscountCalculator() {
            @Override
            public double calculateDiscount(double amount) {
                if(amount>=200){
                    return amount-50;
                }else {
                    return amount;
                }
            }
        };
        DiscountCalculator perCount = new DiscountCalculator() {
            @Override
            public double calculateDiscount(double amount) {
                return amount*0.8;
            }
        };
        double price = 300;
        System.out.println("原价："+price+"元");
        System.out.println("满二百减五十后价格为："+fullCount.calculateDiscount(price)+"元");
        System.out.println("满二百减五十后价格为："+perCount.calculateDiscount(price)+"元");
        double price1 = 150;
        System.out.println("原价："+price1+"元");
        System.out.println("满二百减五十后价格为："+fullCount.calculateDiscount(price1)+"元");
        System.out.println("满二百减五十后价格为："+perCount.calculateDiscount(price1)+"元");
    }
}

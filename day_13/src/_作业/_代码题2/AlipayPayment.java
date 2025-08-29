package _作业._代码题2;

public class AlipayPayment extends Payment {
    public AlipayPayment(String id, String amount) {
        super(id, amount);
    }

    @Override
    public void pay() {
        System.out.println("支付宝支付中.....,订单："+getId()+",金额："+getAmount());
        System.out.println("支付成功！！！");
    }

    public void generatePayLink(){
        System.out.println("生成支付宝支付链接，订单"+getAmount()+"，请用支付宝打开");
    }
}

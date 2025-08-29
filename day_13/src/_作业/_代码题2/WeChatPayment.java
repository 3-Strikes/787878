package _作业._代码题2;

public class WeChatPayment extends Payment {

    public WeChatPayment(String id, String count) {
        super(id, count);
    }

    @Override
    public void pay() {
        System.out.println("微信支付中.....,订单："+getId()+",金额："+getAmount());
        System.out.println("支付成功！！！");
    }

    public void generateQRCode(){
        System.out.println("生成微信支付二维码，订单"+getAmount()+"，请用微信扫描");
    }



}

package _作业._代码题2;

public class PaymentService {
    public void generate_pay_object(Payment payment){
        if(payment instanceof WeChatPayment){
            ((WeChatPayment) payment).generateQRCode();
        }
        if(payment instanceof AlipayPayment)
            ((AlipayPayment) payment).generatePayLink();
    }
}

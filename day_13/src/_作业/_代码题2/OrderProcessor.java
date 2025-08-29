package _作业._代码题2;

public class OrderProcessor {
    // 创建支付对象
    public Payment createPayment(String type, String orderId, String amount) {
        if ("wechat".equalsIgnoreCase(type)) {
            return new WeChatPayment(orderId, amount);
        } else if ("alipay".equalsIgnoreCase(type)) {
            return new AlipayPayment(orderId, amount);
        } else {
            throw new IllegalArgumentException("不支持的支付类型: " + type);
        }
    }

    // 创建支付服务对象
    public PaymentService createPaymentService() {
        return new PaymentService();
    }

    // 触发支付流程
    public void processPayment(Payment payment) {
        PaymentService service = createPaymentService();
        // 生成支付相关信息（二维码/链接）
        service.generate_pay_object(payment);
        // 执行支付操作
        payment.pay();
    }
}

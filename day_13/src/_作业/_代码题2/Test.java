package _作业._代码题2;

public class Test {
    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();

        // 测试微信支付
        System.out.println("=====微信支付流程=====");
        Payment wechatPayment = processor.createPayment("wechat", "ORDER_001", "99.99");
        processor.processPayment(wechatPayment);

        // 测试支付宝支付
        System.out.println("\n=====支付宝支付流程=====");
        Payment alipayPayment = processor.createPayment("alipay", "ORDER_002", "159.50");
        processor.processPayment(alipayPayment);
    }
}

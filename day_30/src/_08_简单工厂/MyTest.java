package _08_简单工厂;

public class MyTest {
    public static void main(String[] args) throws Exception {
        // 1: 利用 工厂,获取USB设备的对象
        USB usb = (USB) MyFactory.getObject("_08_简单工厂.KB");
        USB usb2 = (USB) MyFactory.getObject("_08_简单工厂.Mouse");

        usb.open();
        usb.close();

        usb2.open();
        usb2.close();
    }
}

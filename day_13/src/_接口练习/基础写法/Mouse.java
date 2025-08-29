package _接口练习.基础写法;

public class Mouse implements USB, Battery {
    @Override
    public void open() {
        System.out.println("USB已插入，启动！！！");
    }

    @Override
    public void close() {
        System.out.println("USB拔出，关机！！！");
    }

    @Override
    public void charge() {
        System.out.println("正在充电！！！！");
    }

    @Override
    public void close_charge() {
        System.out.println("结束充电....");
    }
}

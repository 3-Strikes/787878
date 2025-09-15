package _08_简单工厂;

public class KB implements USB{
    @Override
    public void open() {
        System.out.println("键盘开始工作...");
    }

    @Override
    public void close() {

        System.out.println("键盘停止工作...");
    }
}

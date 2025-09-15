package _08_简单工厂;

public class Mouse implements USB{
    @Override
    public void open() {
        System.out.println("鼠标开始工作...");
    }

    @Override
    public void close() {

        System.out.println("鼠标停止工作...");
    }
}

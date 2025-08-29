package _作业._代码题1;

public class Printer extends OfficeDevice {

    public Printer(String id, String brand) {
        super(id, brand);
    }

    @Override
    public void start() {
        System.out.println("打印机 启动！！！");
    }

    public void printDocument(String doc){
        System.out.println("正在打印文档:测试页" +doc);
    }
}

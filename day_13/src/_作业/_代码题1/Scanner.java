package _作业._代码题1;

public class Scanner extends OfficeDevice {
    public Scanner(String id, String brand) {
        super(id, brand);
    }

    @Override
    public void start() {
        System.out.println("扫描启动信息！");
    }
}

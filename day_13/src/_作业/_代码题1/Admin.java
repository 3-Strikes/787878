package _作业._代码题1;

public class Admin {

    private String name;
    private String id;

    public Admin(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void start1(OfficeDevice dev){
        dev.start();
        System.out.println(dev.getId()+"准备启动，品牌名："+dev.getBrand());
        if(dev instanceof Printer){
            ((Printer) dev).printDocument("打印的文档");
        }
    }

    public void start_printer(Printer printer){
        printer.start();
    }

    public void start_scanner(Scanner scanner){
        scanner.start();
    }
}

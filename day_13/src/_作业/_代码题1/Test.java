package _作业._代码题1;

public class Test {
    public static void main(String[] args) {
        Director director = new Director();
        Admin admin = director.generate_admin();
        Printer printer =director.generate_prt();
        Scanner scanner =director.generate_scan();

        director.action(admin,printer);
        director.action(admin,scanner);
        System.out.println("----------");

        admin.start1(printer);
        System.out.println("-----------");
        admin.start1(scanner);

    }
}

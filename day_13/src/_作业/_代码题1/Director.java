package _作业._代码题1;

public class Director {
    public Printer generate_prt() {
        Printer printer =new Printer("PR001","canon");
        return printer;
    }
    public Scanner generate_scan(){
        Scanner scanner =new Scanner("SC002","hp");
        return scanner;
    }

    public Admin generate_admin(){
        Admin admin =new Admin("lizsi","007");
        return admin;
    }

    public void action(Admin admin, OfficeDevice dev){
        System.out.println("主管命令：");
        if(dev instanceof Printer){
            admin.start_printer((Printer) dev);
        }
        if(dev instanceof Scanner){
            admin.start_scanner((Scanner) dev);
        }
    }


}

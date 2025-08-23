package _学生管理系统;
import java.util.ArrayList;
import java.util.Scanner;

/*
    学生管理系统的业务类

    先有一个展示 1 级菜单的方法
    在方法内,让用户选择要执行的功能,并根据用户选择的功能完成具体的任务


 */
public class StudentManager {

    // 为了让多个方法,都能使用这个键盘输入的对象,因此直接设计为成员变量
    private Scanner sc = new Scanner(System.in);
    private ArrayList<Student> list = new ArrayList<>();

    public void showMenu1() {
        System.out.println("=========欢迎进入学生管理系统=========");
        while (true){
            System.out.println("亲,请选择要执行的功能:");
            System.out.println("1:录入学生信息:");
            System.out.println("2:删除学生信息:");
            System.out.println("3:修改学生信息:");
            System.out.println("4:查询学生信息:");
            System.out.println("0:退出系统");
            int a = sc.nextInt();
            switch (a){
                case 1 -> insertStudent();
                case 2 -> deleteStudent();
                case 3 -> updateStudent();
                case 4 -> showMenu2();
                case 0 ->
                {
                    System.out.println("========感谢您的使用,拜拜!========");
                    return;
                }
                default -> System.out.println("输入有误,请重新输入!");
            }
        }
    }

    private void showMenu2() {
        while (true){
            System.out.println("请选择要执行的功能:");
            System.out.println("1:查询所有学生的信息");
            System.out.println("2:根据名称模糊查询");
            System.out.println("0:返回上一级菜单");
            int i = sc.nextInt();
            switch (i){
                case 1 -> showAllStudents();
                case 2 -> showByName();
                case 0 -> {
                    return;
                }
                default -> System.out.println("输入有误，请重新输入！");
            }
        }
    }

    private void showAllStudents() {
        if(list.size()==0){
            System.out.println("集合暂无数据，请先添加学生，再来查询！");
            return;
        }
        System.out.println("请输入学生的姓名包含的字：");
        System.out.println("--------------全部学生信息如下-------------");
        System.out.println("学号\t姓名\t年龄\t生日");
        for (int i = 0; i < list.size(); i++) {
            Student student = list.get(i);
            StringBuilder sbd = new StringBuilder();
            sbd.append(student.getId()).append("\t\t").append(student.getName()).append("\t\t").append(student.getAge()).append("\t\t").append(student.getBirthday());
            System.out.println(sbd);
        }
        System.out.println("----------------------");
    }

    private void showByName() {
        if(list.size()==0){
            System.out.println("集合暂无数据，请先添加学生，再来查询！");
            return;
        }
        String name =sc.next();

        System.out.println("--------------根据"+name+"查询的学生信息如下-------------");
        System.out.println("学号\t姓名\t年龄\t生日");
        for (int i = 0; i < list.size(); i++) {
            Student student = list.get(i);
            if(student.getName().contains(name)){
                StringBuilder sbd = new StringBuilder();
                sbd.append(student.getId()).append("\t\t").append(student.getName()).append("\t\t").append(student.getAge()).append("\t\t").append(student.getBirthday());
                System.out.println(sbd);
            }
        }
        System.out.println("----------------------");
    }

    private void updateStudent() {
        System.out.println("改...");
    }

    private void deleteStudent() {
        System.out.println("删...");
    }

    /*
        思考数据保存的位置?  为了让多个方法共享使用,设计为成员变量
        功能实现:
            键盘输入学生信息,创建学生对象,再把学生对象的地址值添加到集合中即可
     */
    private void insertStudent() {
        String id;
        while (true) {
            System.out.println("请输入学号:");
            id= sc.next();
            // 设计一个方法,专门 根据学号,从集合中找对应的学生对象的索引,如果能找到就返回对应的索引,如果找不到就返回 -1
            int index = findStudentIndexById(id);
            // 如果 index 是 -1 ,说明 id 不存在,可以用,
            if(index == -1){
                break;
            }
            System.out.println(id+"已经存在了,换一个吧~~~");
        }
        System.out.println("请输入姓名:");
        String name = sc.next();
        int age;
        while (true){
            System.out.println("请输入年龄:");
            age= sc.nextInt();
            if(age >= 0 && age <= 100){
                break;
            }
            System.out.println(age+"不是合法的值,请输入[0--100]之间的数字!");
        }
        System.out.println("请输入生日:");
        String birthday = sc.next();
        // 把上面得到的数据封装成学生对象
        Student student = new Student(name,age,id,birthday);
        // 把学生对象添加到集合
        list.add(student);
        System.out.println("亲,添加:"+id+"号学生:"+name+",成功了!");
    }

    // TODO 根据id查询学生id未完成!!!
    private int findStudentIndexById(String id) {
        for (int i = 0; i < list.size(); i++) {
            if(id.equals(list.get(i).getId())){
                return 1;
            }
        }
        return -1;
    }
}


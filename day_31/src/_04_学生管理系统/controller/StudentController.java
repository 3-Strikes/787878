package _04_学生管理系统.controller;

import _04_学生管理系统.domain.Student;
import _04_学生管理系统.service.SService;
import _04_学生管理系统.service.StudentService;

import java.util.Scanner;

/*
    学生管理系统的表现层

    有项目入口,有菜单展示,有数据收集和数据展示

    依赖 service 层

 */
public class StudentController {

    private SService service = new StudentService();
    private Scanner sc = new Scanner(System.in);

    public void showMenu1() {
        System.out.println("=========欢迎进入学生管理系统=========");
        while (true) {
            System.out.println("亲,请选择要执行的功能:");
            System.out.println("1:录入学生信息:");
            System.out.println("2:删除学生信息:");
            System.out.println("3:修改学生信息:");
            System.out.println("4:查询学生信息:");
            System.out.println("0:退出系统");
            int a = sc.nextInt();
            switch (a) {
                case 1 -> insertStudent();
                case 2 -> deleteStudent();
                case 3 -> updateStudent();
                case 4 -> showMenu2();
                case 0 -> {
                    System.out.println("========感谢您的使用,拜拜!========");
                    return;
                }
                default -> System.out.println("输入有误,请重新输入!");
            }
        }
    }

    private void showMenu2() {
        while (true) {
            System.out.println("请选择要执行的功能:");
            System.out.println("1: 查询所有学生信息");
            System.out.println("2: 根据名称模糊查询");
            System.out.println("0: 返回上一级菜单");
            int i = sc.nextInt();
            switch (i) {
                case 1 -> showAllStudents();
                case 2 -> showByName();
                case 0 -> {
                    return;
                }
                default -> System.out.println("输入有误,请重新输入!");
            }
        }
    }

    private void showByName() {
        System.out.println("请输入学生的姓名包含的字:");
        String name = sc.next();
        System.out.println(service.selectByLikeName(name));
    }

    private void showAllStudents() {
        System.out.println(service.selectAll());
    }

    private void updateStudent() {
        System.out.println("请输入要修改的学生学号:");
        String id = sc.next();
        int index = service.findStudentIndexById(id);
        if(index == -1){
            System.out.println("修改失败,"+id+" 不存在!");
        }else {
            Student student1 = new Student();
            student1.setId(id);
            System.out.println("请输入新的姓名:");
            String name = sc.next();
            student1.setName(name);
            while (true) {
                System.out.println("请输入新的年龄:");
                int age = sc.nextInt();
                if (age >= 0 && age <= 100) {
                    student1.setAge(age);
                    break;
                }
                System.out.println(age + "不是合法的值,请输入[0--100]之间的数字!");
            }
            System.out.println("请输入新的生日:");
            String birthday = sc.next();
            student1.setBirthday(birthday);
            String s = service.updateStudent(student1);
            System.out.println(s);
        }
    }

    private void deleteStudent() {
        System.out.println("请输入要删除的学生学号:");
        String id = sc.next();
        // 直接调用  根据id查索引的方法
        String s = service.deleteStudent(id);
        System.out.println(s);
    }

    private void insertStudent() {
        String id;
        while (true) {
            System.out.println("请输入学号:");
            id = sc.next();
            // 专门 根据学号,让业务层找对应的学生对象的索引,如果能找到就返回对应的索引,如果找不到就返回 -1
            int index = service.findStudentIndexById(id);
            // 如果 index 是 -1 ,说明 id 不存在,可以用,
            if (index == -1) {
                break;
            }
            System.out.println(id + "已经存在了,换一个吧~~~");
        }
        System.out.println("请输入姓名:");
        String name = sc.next();
        int age;
        while (true) {
            System.out.println("请输入年龄:");
            age = sc.nextInt();
            if (age >= 0 && age <= 100) {
                break;
            }
            System.out.println(age + "不是合法的值,请输入[0--100]之间的数字!");
        }
        System.out.println("请输入生日:");
        String birthday = sc.next();
        // 把上面得到的数据封装成学生对象
        Student student = new Student(id, name, age, birthday);
        // 把学生对象添加到集合
        String s = service.addStudent(student);
        System.out.println(s);
    }

}

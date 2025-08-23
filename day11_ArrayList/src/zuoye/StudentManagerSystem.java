package zuoye;

import _学生管理系统.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagerSystem {

    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {

        showMenu1();

    }
    public static void showMenu1(){
        while(true){
            System.out.println("----欢迎来到学生管理系统----");
            System.out.println("1.添加学生信息（学号、姓名、年龄）");
            System.out.println("2.查看所有学生信息");
            System.out.println("3.根据学号删除学生信息");
            System.out.println("4.根据学号修改学生信息");
            System.out.println("5.退出系统");
            int q = sc.nextInt();
            switch (q){
                case 1 -> addStudent();
                case 2 -> queryStudent();
                case 3 -> deleteStudent();
                case 4 -> updateStudent();
                case 5 ->{
                    System.out.println("退出系统！");
                    return;
                }
            }
        }
    }

    private static void updateStudent() {
        System.out.println("请输入你要修改学生信息的学号：");
        String id = sc.next();
        int q = findStudentId(id);
        if(q==-1){
            System.out.println("学号错误！请重新输入");
        }else{
            Student stu_update = students.get(q);

            System.out.println("请输入你要修改的姓名：");
            String name = sc.next();
            stu_update.setName(name);
            System.out.println("请输入你要修改的年龄：");
            int age = sc.nextInt();
            stu_update.setAge(age);
            System.out.println("请输入你要修改的出生日期：");
            String birthday = sc.next();
            stu_update.setBirthday(birthday);

            System.out.println("修改成功！");
        }
    }

    private static void deleteStudent() {
        System.out.println("请输入你要删除学生信息的学号：");
        String id = sc.next();
        int q = findStudentId(id);
        if(q==-1){
            System.out.println("学号错误！请重新输入");
        }else{
            students.remove(q);
            System.out.println("删除成功");
        }
    }

    private static int findStudentId(String id) {
        for (int i = 0; i < students.size(); i++) {
            if(students.get(i).getId().equals(id)){
                return i;
            }
        }
        return -1;
    }

    private static void queryStudent() {
        System.out.println("请选择查询方式:");
        System.out.println("1.全部查询");
        System.out.println("2.根据姓名查询");
        int q = sc.nextInt();

        switch (q){
            case 1 -> {
                StringBuilder sbd = new StringBuilder();
                System.out.println("-----查询全部学生信息-----");
                System.out.println("学号\t\t姓名\t\t年龄\t\t出生日期");
                for (int i = 0; i < students.size(); i++) {
                    Student s = students.get(i);
                    sbd.append(s.getId()).append("\t\t").append(s.getName()).append("\t\t").append(s.getAge()).append("\t\t").append(s.getBirthday()).append("\r\n");

                }
                System.out.println(sbd);
            }
            case 2 -> {
                StringBuilder sbd = new StringBuilder();
                System.out.println("-----查询全部学生信息(根据名称查)-----");
                System.out.println("请输入要查询的姓名");
                String name = sc.next();
                System.out.println("1.精确查询");
                System.out.println("2.模糊查询");
                int qq = sc.nextInt();
                switch (qq){
                    case 1 ->{
                        System.out.println("学号\t\t姓名\tt\t年龄\t\t出生日期");
                        for (int i = 0; i < students.size(); i++) {
                            if(students.get(i).getName().equals(name)){
                                Student s = students.get(i);
                                sbd.append(s.getId()).append("\t\t").append(s.getName()).append("\t\t").append(s.getAge()).append("\t\t").append(s.getBirthday()).append("\r\n");
                            }
                        }
                        System.out.println(sbd);
                    }
                    case 2 ->{
                        System.out.println("学号\t\t姓名\tt\t年龄\t\t出生日期");
                        for (int i = 0; i < students.size(); i++) {
                            if(students.get(i).getName().contains(name)){
                                Student s = students.get(i);
                                sbd.append(s.getId()).append("\t\t").append(s.getName()).append("\t\t").append(s.getAge()).append("\t\t").append(s.getBirthday()).append("\r\n");
                            }
                        }
                        System.out.println(sbd);
                    }
                }
            }
        }

    }

    private static void addStudent() {
        System.out.println("请输入添加学生的信息");
        Student stu =new Student();

        System.out.print("学号：");
        String id = sc.next();
        boolean isUnique = false;
        while(true){
            for (int i = 0; i < students.size(); i++) {
                if(students.get(i).getId().equals(id)){
                    System.out.println("该学号已存在，请重新输入！！！");
                    id = sc.next();
                    isUnique=false;
                }else {
                    isUnique =true;
                }
            }
            if(isUnique){
                break;
            }
        }
        stu.setId(id);

        System.out.print("姓名：");
        String name = sc.next();
        stu.setName(name);

        System.out.print("年龄：");
        int age = sc.nextInt();
        while(true){
            if (age>0&&age<100){
                break;
            }else {
                System.out.print("年龄输入超出限制范围，请重新填写：");
                age = sc.nextInt();
            }
        }
        stu.setAge(age);

        System.out.print("出生日期");
        String birthday = sc.next();
        stu.setBirthday(birthday);

        students.add(stu);
        System.out.println("添加成功！");
    }

}

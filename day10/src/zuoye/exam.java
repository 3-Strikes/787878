package zuoye;

import java.util.Scanner;

public class exam {
    public static void main(String[] args) {
        System.out.println("====欢迎来到学生管理系统====");
        System.out.println("输入1，可添加学生信息");
        System.out.println("输入2，可查看所有学生信息");
        System.out.println("输入3，可查找学生信息（按姓名）");
        System.out.println("输入4，可修改学生信息");
        System.out.println("输入5，可退出系统");
        int i = 0;
        Scanner sc = new Scanner(System.in);
        Student[] students = new Student[10];

        while(true){

//            for(Student s:students){
//                if(s==null){
//                    break;
//                }else {
//                    System.out.println(s.toString());
//                }
//            }
            int q = sc.nextInt();

            if(q==5){
                break;
            }
            switch (q){
                case 1 -> {
                    Student s = new Student();
                    System.out.println("请添加学生信息");
                    s = addStudent(s);
                    students[i] = s;
                    i++;
                }
                case 2 -> {
                    sc.nextLine();
                    System.out.println("展示所有学生信息");
                    shouAllStudent(students);
                }
                case 3 -> {
                    System.out.println("请输入查找学生姓名：");
                    sc.nextLine();
                    String name =sc.nextLine();

                    queryStudent(name,students);
                }
                case 4 -> {
                    sc.nextLine();
                    System.out.println("请修改学生信息：");
                    System.out.println("请输入修改学生的姓名：");
                    String name =sc.nextLine();
                    updateStudent(name,students);
                }
            }
        }
    }

    private static void updateStudent(String name, Student[] students) {
        Scanner sc = new Scanner(System.in);
        boolean isreal = false;
        for(Student s:students){
            if(s==null){
                continue;
            }
            if(s.getName().equals(name)){
                isreal = true;
                System.out.println("查询到此人，信息为:");
                System.out.println("学生姓名:"+s.getName()+"     "+"学生年龄:"+s.getAge());
                System.out.println("请输入你要修改的姓名：");
                String name_update = sc.nextLine();
                s.setName(name_update);
                System.out.println("请输入你要修改的年龄：");
                int age_update = sc.nextInt();
                s.setAge(age_update);
                System.out.println("修改成功！");
            }
        }
        if(!isreal){
            System.out.println("查无此人");
        }

    }

    private static void shouAllStudent(Student[] students) {
        for(Student s:students){
            if(s==null){
                break;
            }
            System.out.println("学生姓名:"+s.getName()+"     "+"学生年龄:"+s.getAge());
        }
    }

    private static boolean queryStudent(String name,Student[] students) {
//            for(Student s:students){
//                if(s==null){
//                    break;
//                }else {
//                    System.out.println(s.toString());
//                }
//            }
        boolean isreal = false;
        for(int i=0;i<students.length;i++){
            if(students[i]==null){
                continue;
            }
            if(students[i].getName().equals(name)){
                isreal = true;
                System.out.println("查询到此人，信息为:");
                System.out.println("学生姓名:"+students[i].getName()+"     "+"学生年龄:"+students[i].getAge());
                return true;
            }

        }
        if(!isreal){
            System.out.println("查无此人");
            return  false;
        }
        return isreal;
    }

    public static Student addStudent(Student s){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入学生姓名：");
        String name =sc.nextLine();
        s.setName(name);
        System.out.println("请输入学生年龄：");
        int age = sc.nextInt();
        boolean isleagl = true;
        do{
            if(age<0||age>120){
                System.out.println("请输入合法年龄（0-100）：");
                age = sc.nextInt();
            }
            if(age>=0&&age<=120){
                System.out.println("数据正确！");
                isleagl = false;
            }
        }while (isleagl);

        s.setAge(age);

        System.out.println("添加成功！");
        return s;
    }



}

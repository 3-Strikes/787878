package _01_ArrayList框架;

import java.util.ArrayList;
import java.util.Scanner;

public class MyTest02 {
    public static void main(String[] args) {
        ArrayList<Student> stus = new ArrayList<Student>();
        Scanner sc = new Scanner(System.in);
        int i=1;
        while (true){
            System.out.println("请输入第"+i+"个学生的姓名：");
            String name = sc.next();
            System.out.println("请输入第"+i+"个学生的年龄：");
            int age = sc.nextInt();

            Student stu = new Student(name,age);
            stus.add(stu);

            System.out.println("输入0结束输入，其他继续...");

            String exit = sc.next();

            if("0".equals(exit)){
                break;
            }
            i++;
        }
        for (int i1 = 0; i1 < stus.size(); i1++) {
            Student stui = stus.get(i1);
            System.out.println(stui.getName()+" "+stui.getAge());
        }
    }
}

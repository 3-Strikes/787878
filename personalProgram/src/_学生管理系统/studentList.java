package _学生管理系统;

import java.util.ArrayList;
import java.util.Scanner;

public class studentList {
    static ArrayList<Student> students = new ArrayList<>();

    public studentList(){

    }
    public studentList(ArrayList<Student> students){
        studentList.students = students;
    }
    //1、添加学生信息
    public static void addStudent(Student s){
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入学生姓名：");
        String name = sc.nextLine();
        if(name==null||name==""){
            System.out.println("姓名不能为空,请重新输入:");
            name = sc.nextLine();
            s.setName(name);
        }
        s.setName(name);
        sc.nextLine();

        System.out.println("请输入学生学号：");
        String studentId = sc.nextLine();
        boolean isTrue = false;

        for (int i = 0; i < students.size(); i++) {
            if(students.get(i).getStudentId()==studentId){
                isTrue = false;
                break;
            }else {
                isTrue = true;
            }
        }

        if(isTrue){
            s.setStudentId(studentId);
            sc.nextLine();
        }else {
            System.out.println("该学号已存在，请重洗输入：");
            studentId = sc.nextLine();
            s.setStudentId(studentId);
            sc.nextLine();
        }

        System.out.println("请输入学生语文成绩：");
        double chineseScore = sc.nextDouble();
        if(chineseScore<0||chineseScore>100){
            System.out.println("成绩输入错误（需为0-100的数字），请重新输入：");
            chineseScore = sc.nextDouble();
            s.setChineseScore(chineseScore);
        }
        s.setChineseScore(chineseScore);

        System.out.println("请输入学生数学成绩：");
        double mathScore = sc.nextDouble();
        if(mathScore<0||mathScore>100){
            System.out.println("成绩输入错误（需为0-100的数字），请重新输入：");
            mathScore = sc.nextDouble();
            s.setMathScore(mathScore);
        }
        s.setMathScore(mathScore);

        System.out.println("请输入学生英语成绩：");
        double englishScore = sc.nextDouble();
        if(englishScore<0||englishScore>100){
            System.out.println("成绩输入错误（需为0-100的数字），请重新输入：");
            englishScore = sc.nextDouble();
            s.setEnglishScore(englishScore);
        }
        s.setEnglishScore(englishScore);

        double totalScore = chineseScore+mathScore+englishScore;

        s.setTotalScore(totalScore);
        students.add(s);
        System.out.println("添加成功！");
        sc.close();
    }

    public static void showAllStudents(){
        Scanner sc = new Scanner(System.in);
        if(students.isEmpty()){
            System.out.println("暂无学生成绩，请先添加！");
            return;
        }
        System.out.println("请选择查看方式：");
        System.out.println("1.按录入顺序查看所有学生成绩");
        System.out.println("2.按总分从高到低排序查看");
        System.out.println("3.查询单个学生成绩");
        System.out.println("请输入您的选择（1-3）");
        int q = sc.nextInt();
        switch (q){
            case 1 -> {
                System.out.println("================= 学生成绩列表（按录入顺序） =================");
                System.out.println("姓名  学号      语文  数学  英语  总分  ");
                for (Student student : students) {
                    System.out.println(student.getName() + "  " +student.getStudentId()+"   "+student.getChineseScore()+"    "+student.getMathScore()+"      "+student.getEnglishScore()+"    "+student.getTotalScore());
                }
            }
            case 2 -> {
                System.out.println("================= 学生成绩列表（按总分顺序） =================");
                System.out.println("姓名  学号      语文  数学  英语  总分  ");
                for (Student student : students){
                    System.out.println(student.getName() + "  " +student.getStudentId()+"   "+student.getChineseScore()+"    "+student.getMathScore()+"      "+student.getEnglishScore()+"    "+student.getTotalScore());
                }
            }
            case 3 ->{
                System.out.println("请输入要查询的学生姓名");
                boolean isReal = false;
                String s = sc.nextLine();
                sc.nextLine();
                for(Student student:students){
                    if(student.getName()==s){
                        isReal = true;
                        System.out.println("查询到此人 信息为：");
                        System.out.println("姓名  学号      语文  数学  英语  总分  ");
                        System.out.println(student.getName() + "  " +student.getStudentId()+"   "+student.getChineseScore()+"    "+student.getMathScore()+"      "+student.getEnglishScore()+"    "+student.getTotalScore());
                        break;
                    }
                }
                if(!isReal){
                    System.out.println("查无此人");
                }
            }
        }
    }



}

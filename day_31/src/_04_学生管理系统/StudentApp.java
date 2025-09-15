package _04_学生管理系统;


import _04_学生管理系统.controller.StudentController;

public class StudentApp {
    public static void main(String[] args) {
        // 创建核心类的对象,并调用  showMenu1 方法即可
        new StudentController().showMenu1();
    }
}

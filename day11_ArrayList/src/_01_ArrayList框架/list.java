package _01_ArrayList框架;

import java.util.ArrayList;

public class list {
    public static void main(String[] args) {
        ArrayList<String> students  = new ArrayList<>();
        students.add("大白");
        students.add("小白");
        students.add("6666");//增

        System.out.println(students);

        students.set(1,"大黑白");//改
        System.out.println(students);
        students.remove(1);//删
        System.out.println(students);
        students.remove("大白");
        System.out.println(students);

        String name = students.get(0);//查
        System.out.println(name);


        students.clear();//清空数组
        System.out.println(students.size());
        students = null;//断开与容器的联系
    }
}

package _01_ArrayList框架;

import java.util.ArrayList;

public class Test05 {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student("liliu0",17));
        list.add(new Student("liliu1",17));
        list.add(new Student("liliu2",19));
        list.add(new Student("liliu3",19));
        list.add(new Student("liliu4",15));
        ArrayList<Student> students = getStudents(list);
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            System.out.println(student.getName()+" "+student.getAge());
        }
    }

    public static ArrayList<Student> getStudents(ArrayList<Student> list){
        ArrayList<Student> newList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Student student = list.get(i);
            if(student.getAge()<18){
                newList.add(student);
            }
        }
        return newList;
    }


}

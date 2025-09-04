package _01_test;

import java.util.HashSet;

public class t1 {
    public static void main(String[] args) {
        HashSet<Student> students = new HashSet<>();
        students.add(new Student("小明",18));
        students.add(new Student("小美",18));
        students.add(new Student("小强",18));
        students.add(new Student("小明",18));

        System.out.println(students);

    }
}

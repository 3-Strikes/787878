package _03_序列化;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class t31 {
    public static void main(String[] args) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("e/4.obj"));

        Student student = new Student("张三",18);

        oos.writeObject(student);
        oos.close();
        System.out.println("序列化已完成...");
    }

    public static void rO(){

    }
}

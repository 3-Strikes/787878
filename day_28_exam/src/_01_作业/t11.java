package _01_作业;

import java.io.File;
import java.io.IOException;

public class t11 {
    public static void main(String[] args) throws IOException {
        //创建文件夹
        File f1 = new File("e/testDir");
//        System.out.println(f1.exists());
        f1.mkdir();
        System.out.println(f1.exists());
        //创建文件
        File f2 = new File("e/testDir/test.txt");
//        System.out.println(f2.exists());
        f2.createNewFile();
        System.out.println(f2.exists());

        //输出文件绝对路径
        System.out.println(f1.getAbsolutePath());
        System.out.println(f2.getAbsolutePath());
        //判断文件类型
        System.out.println(f1.isDirectory());
        System.out.println(f1.isFile());

        System.out.println(f2.isFile());
        System.out.println(f2.isDirectory());


    }
}

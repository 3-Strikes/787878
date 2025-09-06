package _02_文件类;

import java.io.File;

public class t1 {
    public static void main(String[] args) {
        File f1  = new File("a\\1.txt");
        System.out.println(f1.exists());
        f1.mkdirs();
        File[] files =  f1.listFiles();

        for (File file : files) {
            System.out.println(file.getAbsoluteFile());
        }
    }
}

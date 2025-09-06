package _04_作业;

import java.io.File;
import java.util.Scanner;

public class zuoye2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要遍历的目录路径：");
        String path = sc.nextLine();

        File dir = new File(path);

        if(!dir.exists()){
            System.out.println("错误 指定目录不存在");
            return;
        }

        if(!dir.isDirectory()){
            System.out.println("错误 输入的路径不是一个目录！");
            return;
        }

        System.out.println("目录下所有的 .java文件绝对路径如下：");
        traverseDirectory(dir);

    }

    private static void traverseDirectory(File dir) {
        File[] files = dir.listFiles();

        if(files==null){
            return;
        }

        for (File file : files) {
            if(file.isFile()){
                if(file.getName().endsWith(".java")){
                    System.out.println(file.getAbsoluteFile());
                }
            }else if(file.isDirectory()){
                traverseDirectory(file);
            }
        }


    }
}

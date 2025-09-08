package _07_额外作业;

import java.io.File;

public class t72 {
    public static void main(String[] args) {
        File f1 = new File("day_24");
        printDir(f1,0);

    }

    public static void printDir(File dir,int num){
        printFileName(num,dir);
        num++;

        File[] files = dir.listFiles();

        if(files==null||files.length==0){
            return;
        }

        for (File file : files) {
            if(file.isFile()){
                printFileName(num,file);
            }
            if(file.isDirectory()){
                printDir(file,num);
            }

        }

    }

    private static void printFileName(int num, File dir) {
        for (int i = 0; i < num; i++) {
            System.out.print("\t");
        }

        System.out.println("| - "+dir.getName());

    }
}

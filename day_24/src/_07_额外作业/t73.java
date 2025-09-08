package _07_额外作业;

import java.io.File;

public class t73 {
    public static void main(String[] args) {
        File file = new File("day_24");
        long size = getSize(file);
        System.out.println("文件大小为："+size+"字节");
    }

    public static long getSize(File dir){
        long size = 0;

        File[] files = dir.listFiles();
        if(files==null||files.length==0){
            return size;
        }

        for (File file : files) {
            if(file.isFile()){
                size+=file.length();
            }

            if(file.isDirectory()){
                size+=getSize(file);
            }
        }
        return size;
    }

}

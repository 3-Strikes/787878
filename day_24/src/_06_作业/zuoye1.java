package _06_作业;

import java.io.*;

public class zuoye1 {
    public static void main(String[] args) throws IOException {
        File f1 = new File("e/转换流的图解.png");
        File f2 = new File("e/copy.png");

        long start = System.currentTimeMillis();
//        copy01(f1,f2);//单字节复制
        copy02(f1,f2);//字节数组复制
        long end = System.currentTimeMillis();
        System.out.println("单字节复制的速度为："+(end-start)+"毫秒");


    }

    public static void copy01(File f1,File f2) throws IOException {
        FileInputStream fis = new FileInputStream(f1);
        FileOutputStream fos = new FileOutputStream(f2);
        int len = 0;
        while((len=fis.read())!=-1){
            fos.write(len);
        }
        fis.close();
        fos.close();
    }

    public static void copy02(File f1,File f2) throws IOException {
        FileInputStream fis = new FileInputStream(f1);
        FileOutputStream fos = new FileOutputStream(f2);

        int len = 0 ;
        byte[] bs = new byte[8192];
        while((len=fis.read(bs))!=-1){
            fos.write(len);
        }
        fis.close();
        fos.close();
    }

}

package _05_缓冲流;

import java.io.*;

public class t51 {
    public static void main(String[] args) throws IOException {
        File f1 = new File("e/字节流-字符流-缓冲流-编码表-异常处理.pptx");
        File f2 = new File("e/2.txt");

        long start = System.currentTimeMillis();
        copy02(f1,f2);
        long end = System.currentTimeMillis();
        System.out.println("总耗时："+(end-start)+"毫秒");

    }


    public static void copy02(File f1 , File f2) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(f1));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(f2));
        int len = 0;
        byte[] bs = new byte[1024];
        while((len = bis.read(bs))!=-1){
            bos.write(bs,0,len);
        }
        bis.close();
        bos.close();

    }

    public static void copy01(File f1,File f2) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(f1));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(f2));
        int b = 0;
        while((b=bis.read())!=-1){
            bos.write(b);
        }
        bis.close();
        bos.close();

    }
}

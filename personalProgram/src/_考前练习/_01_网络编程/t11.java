package _考前练习._01_网络编程;

import java.io.*;

public class t11 {
    public static void main(String[] args) throws IOException {

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("e/1.txt"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("e/1.1.txt"));//万能 缓冲字节输出/输入流
        byte[] buffer = new byte[1024];
        int len ;
        while((len=bis.read(buffer))!=-1){
            bos.write(buffer,0,len);
        }

    }
}

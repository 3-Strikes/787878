package _02_输入流;

import java.io.FileInputStream;
import java.io.IOException;

public class t21 {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("e/1.txt");
        int zhi;


//        while((zhi=fileInputStream.read())!=-1){
//            System.out.print(zhi+" ");
//        }

        byte[] arr = new byte[4];
        while((zhi=fileInputStream.read(arr))!=-1){
            String s = new String(arr,0,zhi);
//            String s = new String(arr); //如果遇到中文该写法可能会报错，每次固定读指定字节容量的数据
            System.out.print(s);
        }
        fileInputStream.close();
    }
}

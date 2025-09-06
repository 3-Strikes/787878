package _03_文件复制;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MyCopy {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("e/1.txt");
        FileOutputStream fos = new FileOutputStream("e/2.txt");

        byte[] arr = new byte[8888];
        int count;
        while((count=fis.read(arr))!=-1){
            fos.write(arr,0,count);
        }

        fos.close();
        fis.close();
        System.out.println("复制完成！！");
    }
}

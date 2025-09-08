package _02_转换流;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;

public class t22 {
    public static void main(String[] args) throws IOException {
        //创建FileReader对象 默认的编码是utf-8 而 1，txt本身是gbk，所以会导致这个流读数据出现了乱码，使用Charset.forName方法指定编码格式 是jdk11之后使用的方法，乱码的原因只怪读的编码不对。
        FileReader fr = new FileReader("e/1.txt", Charset.forName("gbk"));
        char[] arr = new char[10];
        int len = 0;
        while((len=fr.read(arr))!=-1){
            System.out.println(new String(arr,0,len));
        }
        fr.close();
    }
}

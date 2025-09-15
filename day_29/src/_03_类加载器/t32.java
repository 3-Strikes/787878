package _03_类加载器;

import java.io.IOException;
import java.io.InputStream;

public class t32 {
    public static void main(String[] args) throws IOException {
        //1: 获取类加载器对象
        ClassLoader app = t32.class.getClassLoader();
        InputStream in = app.getResourceAsStream("1.txt");//相对路径，相对于Src文件

        System.out.println(in);
        byte[] bytes = in.readAllBytes();
        System.out.println(new String(bytes));
    }
}

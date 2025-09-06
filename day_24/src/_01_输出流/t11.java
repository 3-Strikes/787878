package _01_输出流;

import java.io.FileOutputStream;
import java.io.IOException;

public class t11 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("e/1.txt");//如果有 则清空在创建，没有就直接

        FileOutputStream fileOutputStream1 = new FileOutputStream("e/2.txt",true);//如果有就直接使用，如果没有则创建。

        byte[] arr = {45,46,47,58,49,50};
        fileOutputStream.write(70);
        fileOutputStream.write(arr);
        fileOutputStream.write(arr,1,4);
        fileOutputStream.close();
        //换行输入 用“/r/n.getbytes()实现   ”
        fileOutputStream1.write(70);
        fileOutputStream1.write(arr);
        fileOutputStream1.write(arr,1,4);

    }
}

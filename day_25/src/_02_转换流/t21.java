package _02_转换流;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class t21 {
    public static void main(String[] args) throws IOException {
        InputStreamReader ifr = new InputStreamReader(new FileInputStream("e/1.txt"),"GBK");
        char[] arr = new char[10];
        int len = 0;
        while((len = ifr.read(arr))!=-1) {
            System.out.println(new String(arr, 0, len));
        }
        ifr.close();
    }
}

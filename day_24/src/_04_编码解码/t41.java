package _04_编码解码;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class t41 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String s = "中国人";
        byte[] arr1 = s.getBytes();
        System.out.println(Arrays.toString(arr1));

        String s1 = new String(arr1);
        System.out.println(s1);

        byte[] arr2 = s.getBytes("gbk");
        System.out.println(Arrays.toString(arr2));
        String s2 = new String(arr2,"gbk");
        System.out.println(s2);

    }
}

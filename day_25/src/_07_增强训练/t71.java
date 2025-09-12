package _07_增强训练;

import java.io.*;

public class t71 {
    public static void main(String[] args) throws Exception {
        String srcpath = "e/61.txt";
        String srccode = "utf-8";

        String destpath = "e/61.1.txt";
        String destcode = "GBK";
        convert(srcpath,destpath,srccode,destcode);
    }

    public static void convert(String srcPath,String destPath,String srcCode,String destCode)throws Exception{
        File f1 = new File(srcPath);
        File f2 = new File(destPath);
        InputStreamReader isr = new InputStreamReader(new FileInputStream(srcPath),srcCode);
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(destPath),destCode);

        char[] chs = new char[1024];
        int len = 0;
        while((len = isr.read(chs))!=-1){
            osw.write(chs,0,len);
        }

        isr.close();
        osw.close();

    }

}

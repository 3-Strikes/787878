package _06_作业;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IORuntimeException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class t62 {
    public static void main(String[] args) throws IOException {
        String srcPath = "e/source.txt";
        String tarPath = "e/target.txt";

        FileWriter fw = new FileWriter(srcPath);
        fw.write("这是作业这是作业这是作业这是作业");
        fw.close();
        try {
            File f1 = new File(srcPath);
            File f2 = new File(tarPath);
            FileUtil.copy(f1,f2,true);
            System.out.println("复制完成...");
        } catch (IORuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}

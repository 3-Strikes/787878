package _01_作业;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IORuntimeException;
import cn.hutool.core.io.IoUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class t12 {
    public static void main(String[] args) throws IOException {
        String content="hello \r\n";
        String path = "e/testDir/test.txt";
        FileInputStream fis = new FileInputStream(new File("e/testDir/test.txt"));
        FileOutputStream fos = new FileOutputStream(new File("e/testDir/copy_text.txt"));
        try {
            File file = FileUtil.writeUtf8String(content,new File(path));
            FileUtil.appendUtf8String("Hutool \r\n",file);
            FileUtil.appendUtf8String("IO",file);
        }catch (IORuntimeException e){
            //抛出一个运行时异常(直接停止掉程序)
            throw new RuntimeException("运行时异常",e);
        }
        System.out.println(FileUtil.readUtf8String("e/testDir/test.txt"));
        IoUtil.copy(fis,fos);
    }
}

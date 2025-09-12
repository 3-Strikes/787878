package _06_作业;

import java.io.*;
import java.util.Properties;

public class t61 {
    public static void main(String[] args) throws IOException {
//        load();
        Properties p = new Properties();
        FileReader fr = new FileReader("e/61.txt");
        try(FileInputStream fis = new FileInputStream("e/61.txt")){
            p.load(fis);
            String scoreStr = p.getProperty("score");
            if(scoreStr!=null){
                int score = Integer.parseInt(scoreStr);
                score+=20;

                p.setProperty("score", String.valueOf(score));
                try(FileOutputStream fos = new FileOutputStream("e/61.txt")){
                    p.store(fos,"Update...");
                    System.out.println("文件已更新，新的score值为："+score);
                }
            }else {
                System.out.println("未找到该文件。");
            }

        }catch (Exception e){
            e.printStackTrace();
        }


    }

    private static void load() throws IOException {
        Properties p = new Properties();
        p.setProperty("name","张三");
        p.setProperty("age","18");
        p.setProperty("score","80");

        FileWriter fw = new FileWriter("e/61.txt");

        p.store(fw,"just homewo");
        fw.close();

    }


}

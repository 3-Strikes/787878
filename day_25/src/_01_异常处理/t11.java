package _01_异常处理;

import java.io.*;
import java.util.TreeSet;

public class t11 {
    public static void main(String[] args) {
        TreeSet<String> set = new TreeSet<>();
        //传统写法
        BufferedReader br = null;
        try {
            br=new BufferedReader(new FileReader("e/1.txt"));
            String line;
            while((line = br.readLine())!=null){
                set.add(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if(br!=null){
                    br.close();
                }
            }catch (IOException e){
                throw new RuntimeException(e);
            }
        }
//        br.close();
        //新鲜写法 try with resource
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("e/2.txt"))){

            for (String s : set) {
                bw.write(s);
                bw.newLine();
                bw.flush();
            }
        }catch (Exception e){
            e.printStackTrace();
        }



    }
}

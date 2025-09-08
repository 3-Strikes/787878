package _06_作业;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class zuoye2 {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("e/1.txt");
        FileReader fr = new FileReader("e/1.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        BufferedReader br = new BufferedReader(fr);
        bw.write("3.香蕉");
        bw.newLine();
        bw.write("1.苹果");
        bw.newLine();
        bw.write("5.橙子");
        bw.newLine();
        bw.write("2.葡萄");
        bw.newLine();
        bw.write("4.西瓜");
        bw.newLine();
        bw.flush();
        System.out.println("写入完成");
        List<String> sortFilelist = readAndSortFile(br);

        System.out.println("排序后的内容为:");
        for (String s : sortFilelist) {
            System.out.println(s);
        }


    }

    private static List<String> readAndSortFile(BufferedReader br) throws IOException {
        String line;
        List<String> list = new ArrayList<>();
        while((line=br.readLine())!=null){
            if(!line.trim().isEmpty()){
                list.add(line);
            }
        }

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                    int num1 = exNumber(o1);
                    int num2 =exNumber(o2);
                    return Integer.compare(num1,num2);
            }

            private int exNumber(String str){
                try {
                    int dontIndex = str.indexOf('.');
                    if(dontIndex>0){
                        String numstr = str.substring(0,dontIndex);
                        return Integer.parseInt(numstr.trim());//分割字符串 方法 很关键
                    }
                }catch (NumberFormatException e){
                    return Integer.MAX_VALUE;
                }
                return Integer.MAX_VALUE;
            }
        });
        return list;
    }
}

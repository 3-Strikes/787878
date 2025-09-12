package _07_增强训练;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class t72 {
    public static void main(String[] args) throws IOException {
        File f1 = new File("e/t72.1.txt");
        List<String> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("e/t72.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("e/t72.1.txt"));

        String line;
        while((line = br.readLine())!=null){
            StringBuffer sb = new StringBuffer(line);
            String linereverse = new String(sb.reverse().toString());
            list.add(linereverse);
        }
        br.close();
        for (int size = list.size()-1; size >= 0; size--) {
            bw.write(list.get(size));
        }
        bw.close();

    }
}

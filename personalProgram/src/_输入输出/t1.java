package _输入输出;

import java.io.*;

public class t1 {
    public static void main(String[] args) throws IOException {
//        try(FileInputStream fis = new FileInputStream("e/61.txt")){
//            int s;
//            while((s= fis.read())!=-1){
//                System.out.print((char) s);
//            }
//
//        }catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        try(BufferedReader br = new BufferedReader(new FileReader("e/61.txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("e/61.1.txt"))) {
            String line;
            while((line=br.readLine())!=null){
                bw.write(line);
                bw.newLine();
                System.out.println(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

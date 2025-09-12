package _02_挑战;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class StuClient2 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",8888);
        try (BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
             Scanner sc = new Scanner(System.in);
        ){
            Thread readThread = new Thread(()->{
                String strread = "";
                try {
                    while((strread=br.readLine())!=null){
                        System.out.println("服务器回复："+strread);

                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });

            readThread.start();

            String str = "";
            while(true){
                System.out.print("客户端的请求为：");
                str = sc.nextLine();
                if("exit".equals(str)){
                    System.out.println("退出链接...");
                    bw.write(str+'\n');
                    bw.flush();
                    break;
                }
                bw.write(str+'\n');
                bw.flush();
            }



        }catch (Exception e){
            e.printStackTrace();
        }



    }
}

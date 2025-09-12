package _自己敲的;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class T1Client_a {
    public static void main(String[] args) throws IOException {
        try (Socket s = new Socket("127.0.0.1",8888);
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
             BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
             Scanner sc = new Scanner(System.in)){

            Thread readThread = new Thread(()->{
                try {
                    String str;
                    while((str=br.readLine())!=null){
                        System.out.println("服务器传回的数据为："+str);
                        if(str.contains("88")){
                            break;
                        }
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });

            readThread.start();

            while(true){
                System.out.println("向服务器传输的信息为：");
                String msg = sc.nextLine();

                bw.write(msg+'\n');
                bw.flush();
                if("88".equals(msg)){
                    break;
                }
            }
            readThread.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.println("客户端已关闭");
        }
    }
}

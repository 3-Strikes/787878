package _01_作业;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class t13C3 {
    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = new Socket("127.0.0.1",8888);
        //客户端发
        Thread thread1 = new Thread(()->{
            Scanner sc = new Scanner(System.in);
            while(true){
                System.out.println("我是客户端，我发送的消息是：");
                String string = sc.next();
                if("88".equals(string)){
                    break;
                }
                try {
                    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                    bw.write(string);
                    bw.newLine();
                    bw.flush();

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        //客户端读
        Thread thread2 = new Thread(()->{
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                while (true) {
                    String string = br.readLine();
                    System.out.println("客户端收到服务端的信息是："+string);
                    if("88".equals(string)){
                        break;
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });


        thread1.start();
//        thread2.start();

        thread1.join();
        thread2.join();

        socket.close();
    }
}

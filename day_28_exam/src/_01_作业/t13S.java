package _01_作业;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class t13S {//服务端
    public static void main(String[] args) throws IOException, InterruptedException {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                3
                ,3
                ,3
                , TimeUnit.MINUTES
                ,new ArrayBlockingQueue<>(3)
                ,new ThreadPoolExecutor.AbortPolicy()
        );
        ServerSocket ss = new ServerSocket(8888);
        Socket socket = ss.accept();

        //服务端读
        Thread thread1 = new Thread(()->{
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                while (true) {
                    String string = br.readLine();
//                    System.out.println(string);
                    System.out.println("我收到客户端的信息是："+string);
                    if("88".equals(string)){
                        break;
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        //服务端发
        Thread thread2 = new Thread(()->{
            Scanner sc = new Scanner(System.in);
            while(true){
                System.out.println("我是服务端，我发送的消息是：");
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
//        thread1.start();
//        thread2.start();

        pool.execute(thread1);

//        thread1.join();
//        thread2.join();
//
//        socket.close();
//        pool.shutdown();
    }
}

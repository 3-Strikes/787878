package _03_网络编程_多次读写;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class t31 {

    public static void main(String[] args) throws IOException, InterruptedException {
        Socket s = new Socket("127.0.0.1",12345);
        Thread thread1 = new Thread(()->{
            try {
                Scanner sc = new Scanner(System.in);
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
                while(true){
                    System.out.println("我是客户端，请输入您想对服务器说的话：输入886 退出");
                    String string = sc.nextLine();
                    bw.write(string);
                    bw.newLine();
                    bw.flush();
                    if(string.equals("886")){
                        break;
                    }
                }
//                bw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });


        Thread thread2 = new Thread(()->{
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
                while(true){
                    System.out.println("我是客户端，我收到的服务器说的话是：");
                    String string = br.readLine();
                    if("886".equals(string)){
                        break;
                    }
                }
//                br.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        });
        //线程启动
        thread1.start();
        thread2.start();
//让main等待 t1 t2 结束后在执行下面的代码
        thread1.join();
        thread2.join();
        s.close();
        System.out.println("main结束了....");

    }
}

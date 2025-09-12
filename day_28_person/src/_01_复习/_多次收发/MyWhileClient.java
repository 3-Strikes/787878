package _01_复习._多次收发;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/*
    模拟聊天功能的循环读写效果
 */
public class MyWhileClient {
    public static void main(String[] args) throws IOException, InterruptedException {
        // 1: 创建客户端
        Socket socket = new Socket("127.0.0.1",8888);
        // 2: 创建两个线程,分别负责读,写
        Thread t1=new Thread(()->{
            try {
                // 循环写
                Scanner sc = new Scanner(System.in);
                // 准备字符缓冲输出流
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                while (true){
                    System.out.println("我是客户端,请输入您想对服务器说的话:(输入 886 结束通话)");
                    String s = sc.nextLine();
                    // 把 s 写给服务器
                    bw.write(s);
                    bw.newLine();
                    bw.flush();
                    if("886".equals(s)){
                        break;
                    }
                }
                //bw.close();
            } catch (Exception e) {
                //throw new RuntimeException(e);
                e.printStackTrace();
            }
        });

        // 循环读
       Thread t2= new Thread(()->{
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                while (true){
                    String s = br.readLine();
                    System.out.println("我是客户端,我收到了服务器的信息是:"+s);
                    if("886".equals(s)){
                        break;
                    }
                }
                //br.close();
            } catch (Exception e) {
                //throw new RuntimeException(e);
                e.printStackTrace();
            }
        });
        //  使用 线程的 加入的功能
        t1.start();
        t2.start();

        // 让main等待 t1和t2结束后,再执行下面的代码
        t1.join();
        t2.join();

        socket.close();
        System.out.println("mian结束了.....");
    }
}

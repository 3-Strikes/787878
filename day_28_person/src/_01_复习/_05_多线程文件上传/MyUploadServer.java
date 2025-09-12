package _01_复习._05_多线程文件上传;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;

/*
    文件上传的服务端
 */
public class MyUploadServer {
    public static void main(String[] args) throws IOException {
        // 1: 创建服务端
        ServerSocket ss = new ServerSocket(9999);
        while (true) {
            System.out.println("服务器正在等待客户端的链接.............");
            Socket socket = ss.accept();
            // 创建一个线程,负责与 socket 对象,进行交互,无论线程的任务是否执行完成,都不影响while循环等待下一个客户端的链接
            new Thread(()->{
                try {
                    // 2: 准备一个本地的文件字节输出流
                    FileOutputStream fount = new FileOutputStream("D:\\"+ UUID.randomUUID().toString()+".jpg");
                    // 2.5: 准备一个网络输入流
                    InputStream in = socket.getInputStream();
                    // 3: 循环读文件的数据
                    byte[] arr = new byte[8192];
                    int len ;
                    while ((len=in.read(arr))!= -1){
                        // 写到网络中
                        fount.write(arr,0,len);
                        //Thread.sleep(100);
                    }
                    // 从本地文件写数据结束了,应该给对方提醒一下,文件存好了
                    // 4: 读服务器的响应
                    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                    bw.write("亲,保存文件成功啦");
                    bw.newLine();
                    bw.close();
                    socket.close();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }).start();
            System.out.println("已经安排了线程与:"+socket.getInetAddress().getHostAddress()+"交互..........");
        }


        //ss.close(); // 服务器永不停止
    }
}

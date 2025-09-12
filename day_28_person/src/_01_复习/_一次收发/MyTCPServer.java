package _01_复习._一次收发;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/*
    一发一收的服务器端代码实现
 */
public class MyTCPServer {
    public static void main(String[] args) throws IOException {
        // 1: 创建服务器端对象
        ServerSocket ss = new ServerSocket(12345);
        // 2: 等待客户端连接
        Socket s = ss.accept();
        // 3: 面向scoket对象,获取 io 流,与客户端进行交互
        // 读服务器给我们响应的数据
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String s1 = br.readLine();
        System.out.println("我是服务器端,我收到客户端说的话是:"+s1);
        // 4: 给客户端回一句话
        OutputStream outputStream = s.getOutputStream();
        // 为了写数据和将来服务器读数据方便,将字节流,先包装成字符转换后,再讲字符转换流包装成字符缓冲流,就可以利用字符缓冲流的读一行和写一行的功能了
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));
        bw.write("客户端你好啊,我是服务器哦...");
        bw.newLine();
        bw.flush();
        br.close();
        bw.close();
        ss.close();
    }
}

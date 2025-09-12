package _02_网络编程_一次读写;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class t22 {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(12345);
        Socket s = ss.accept();

        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String s1 = br.readLine();
        System.out.println("我是服务器端 我收到的客户端说的话是："+s1);
        OutputStream os =s.getOutputStream();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
        bw.write("客户端你好，我是服务器。。");
        bw.newLine();
        bw.flush();


        bw.close();
        br.close();
        ss.close();
    }
}

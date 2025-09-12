package _02_网络编程_一次读写;

import java.io.*;
import java.net.Socket;

public class t21 {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("192.168.0.115",12345);
        OutputStream os = s.getOutputStream();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
        bw.write("关注永雏塔菲谢谢喵....");
        bw.newLine();
        bw.flush();

        BufferedReader br =  new BufferedReader(new InputStreamReader(s.getInputStream()));
        String s1 = br.readLine();
        System.out.println("我是客户端，我收到服务器响应的数据是:"+s1);
        br.close();
        bw.close();


    }
}

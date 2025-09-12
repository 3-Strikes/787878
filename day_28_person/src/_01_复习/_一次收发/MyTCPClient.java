package _01_复习._一次收发;

import java.io.*;
import java.net.Socket;

/*
    TCP通信的客户端代码
 */
public class MyTCPClient {
    public static void main(String[] args) throws IOException {
        // 1: 创建客户端对象  这个构造方法中,会自动完成 3次握手!!!
        //Socket s = new Socket("192.168.0.100",12345);
        Socket s = new Socket("127.0.0.1",12345);
        // 2: TCP 的通信是基于 IO 流完成,因此想给服务器发信息,需要使用 输出流输出数据
        OutputStream outputStream = s.getOutputStream();
        // 为了写数据和将来服务器读数据方便,将字节流,先包装成字符转换后,再讲字符转换流包装成字符缓冲流,就可以利用字符缓冲流的读一行和写一行的功能了
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));
        bw.write("服务器你好啊,我是客户端哦...");
        bw.newLine();
        bw.flush();
        // 读服务器给我们响应的数据
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String s1 = br.readLine();
        System.out.println("我是客户端,我收到服务器响应的数据是:"+s1);
        bw.close();
        br.close();
        s.close();
    }
}

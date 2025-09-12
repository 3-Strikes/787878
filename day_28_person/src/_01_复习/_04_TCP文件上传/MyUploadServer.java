package _01_复习._04_TCP文件上传;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/*
    文件上传的服务端
 */
public class MyUploadServer {
    public static void main(String[] args) throws IOException {
        // 1: 创建服务端
        ServerSocket ss = new ServerSocket(9999);
        Socket socket = ss.accept();
        // 2: 准备一个本地的文件字节输出流
        FileOutputStream fount = new FileOutputStream("D:\\123456.txt");
        // 2.5: 准备一个网络输入流
        InputStream in = socket.getInputStream();
        // 3: 循环读文件的数据
        byte[] arr = new byte[8192];
        int len ;
        while ((len=in.read(arr))!= -1){
            // 写到网络中
            fount.write(arr,0,len);
        }
        // 从本地文件写数据结束了,应该给对方提醒一下,文件存好了
        // 4: 读服务器的响应
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write("亲,保存文件成功啦");
        bw.newLine();
        bw.close();
        socket.close();
        ss.close();
    }
}

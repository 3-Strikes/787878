package _01_复习._06_线程池文件上传;

import java.io.*;
import java.net.Socket;

/*
    文件上传的客户端
 */
public class MyUploadClient {
    public static void main(String[] args) throws IOException {
        // 1: 创建客户端
        Socket socket = new Socket("127.0.0.1",9999);
        // 2: 准备一个本地的文件字节输入流
        FileInputStream fin = new FileInputStream("C:\\Users\\Administrator\\Desktop\\Snipaste_2025-09-10_16-45-14.jpg");
        // 2.5: 准备一个网络输出流
        OutputStream os = socket.getOutputStream();
        // 3: 循环读文件的数据
        byte[] arr = new byte[8192];
        int len ;
        while ((len=fin.read(arr))!= -1){
            // 写到网络中
            os.write(arr,0,len);
        }
        // 从本地文件读数据结束了,应该给对方提醒一下,文件写完了????
        socket.shutdownOutput();// 相当于告诉对方,我们已经写完了!!!
        // 4: 读服务器的响应
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String s = br.readLine();
        System.out.println("我是客户端,我收到了服务器的响应是:"+s);
        br.close();
        fin.close();
        socket.close();
    }
}

package _05_作业;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        try {
            ServerSocket ss = new ServerSocket(8888);
            System.out.println("服务端启动，等待客户端链接。。。");
            Socket socket = ss.accept();
            OutputStream os = socket.getOutputStream();
            FileInputStream fis = new FileInputStream("e/serverFile.txt");
            BufferedInputStream bis = new BufferedInputStream(fis);

            BufferedOutputStream bos = new BufferedOutputStream(os);

            byte[] buffer = new byte[1024];

            int len  ;
            while((len=bis.read(buffer))!=-1){
                bos.write(buffer,0,len);
            }
            bos.flush();
            socket.shutdownOutput();
            System.out.println("文件传输完成.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

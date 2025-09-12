package _06_豆包;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        ServerSocket ss = null;
        Socket socket = null;
        try {
            ss = new ServerSocket(8888);
            System.out.println("服务端启动，等待客户端链接...");
            socket = ss.accept();
            
            // 读取本地文件并发送
            OutputStream os = socket.getOutputStream();
            FileInputStream fis = new FileInputStream("e/serverFile.txt");
            BufferedInputStream bis = new BufferedInputStream(fis);
            BufferedOutputStream bos = new BufferedOutputStream(os);

            byte[] buffer = new byte[1024];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
            bos.flush();
            
            // 关键：告知客户端数据已发送完毕（关闭输出流，但保持连接）
            socket.shutdownOutput();
            System.out.println("文件传输完成.");

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            // 关闭所有资源
            try {
                if (socket != null) socket.close();
                if (ss != null) ss.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
    
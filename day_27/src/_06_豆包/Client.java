package _06_豆包;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        Socket socket = null;
        try {
            socket = new Socket("127.0.0.1", 8888);
            
            // 接收文件并保存
            InputStream in = socket.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(in);
            FileOutputStream fos = new FileOutputStream("e/下载文件.txt");
            BufferedOutputStream bos = new BufferedOutputStream(fos);

            byte[] buffer = new byte[8192];
            int len;
            // 当服务端调用shutdownOutput()后，read()会返回-1，循环结束
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
            bos.flush(); // 确保数据写入文件
            
            System.out.println("下载完成");

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            // 关闭资源
            try {
                if (socket != null) socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
    
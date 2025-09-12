package _05_作业;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        try {
            Socket socket = new Socket("127.0.0.1",8888);

            InputStream in = socket.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(in);

            FileOutputStream fos = new FileOutputStream("e/下载文件.txt");
            BufferedOutputStream bos = new BufferedOutputStream(fos);

            byte[] buffer = new byte[8192];
            int len ;
            while((len=bis.read(buffer))!=-1){
                bos.write(buffer,0,len);
            }
            bos.flush();
            System.out.println("下载完成");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

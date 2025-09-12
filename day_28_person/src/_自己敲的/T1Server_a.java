package _自己敲的;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class T1Server_a {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8888);
        System.out.println("服务器已启动，等待客户端链接....");
        Socket s = ss.accept();
        System.out.println("客户端已连接...");

        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
             BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()))
        ){
            String clientMsg;
            while((clientMsg=br.readLine())!=null){
                System.out.println("客户端传来的信息是："+clientMsg);
                if("88".equals(clientMsg)){
                    bw.write("服务器已收到退出指令，连接关闭\n");
                    bw.flush();
                    break;
                }
                bw.write(clientMsg+"宇智波反弹！！！\n");
                bw.flush();
                System.out.println("服务器端已返回响应");

            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            s.close();
            ss.close();
            System.out.println("服务器已关闭");
        }

    }
}

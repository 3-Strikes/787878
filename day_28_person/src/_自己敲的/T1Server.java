package _自己敲的;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class T1Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8888);
        System.out.println("服务器已启动，等待客户端连接....");
        Socket socket = ss.accept();
        System.out.println("客户端已连接...");

        InputStream in = socket.getInputStream();//读取客户端送来的数据流写入流
        OutputStream os = socket.getOutputStream();//返还给客户端接收数据后的反应流

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os)); //返还客户端信息
        BufferedReader br = new BufferedReader(new InputStreamReader(in)); //读客户端传来的数据
        //读客户端的数据
        Thread thread1 = new Thread(()->{
            try {
                while (true) {
                    String string = br.readLine();
                    if("88".equals(string)){
                        break;
                    }
                    System.out.println("客户端传来的信息是："+string);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        //向客户端写数据
        Thread thread2 = new Thread(()->{
            String string = null;
            while (true) {
                if("88".equals(string)){
                    break;
                }
                try {
                    string = br.readLine();
                    bw.write(string+"宇智波反弹！！！"+'\n');
                    bw.flush();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("服务端已读取到客户端的数据并反弹会一个信息。。。");
            }
        });


        thread1.start();
        thread2.start();


    }
}

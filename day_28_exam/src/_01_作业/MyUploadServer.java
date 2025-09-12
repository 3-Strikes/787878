package _01_作业;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/*
    文件上传的服务端
 */
public class MyUploadServer {
    public static void main(String[] args) throws IOException {

        ServerSocket ss = new ServerSocket(8888);


        ThreadPoolExecutor pool = new ThreadPoolExecutor(3, 3, 0, TimeUnit.MINUTES, new ArrayBlockingQueue<>(2), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        while (true) {
            System.out.println("服务器正在等待客户端的链接.............");
            Socket socket = ss.accept();
            pool.execute(() -> {
                try {
                    BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    InputStream in = socket.getInputStream();
                    String string = br.readLine();
                    System.out.println("我是服务器，我收到的消息是："+string);

                    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                    bw.write("读取成功");
                    bw.newLine();
                    bw.close();
                    socket.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            System.out.println("已经安排了线程与:" + socket.getInetAddress().getHostAddress() + "交互..........");
        }


        //ss.close(); // 服务器永不停止
    }
}

package _05_作业;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServeTcp {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = null;
        Socket socket = null;
        try {
            ss = new ServerSocket(8888);
            socket = ss.accept();
            InputStream in = socket.getInputStream();
            System.out.println("等待接收消息....");
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String s = br.readLine();
            System.out.println("我是服务端 ，我收到的消息是："+s);

            OutputStream os = socket.getOutputStream();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
            bw.write("已收到：Hello TCP!");
            bw.newLine();
            bw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        socket.close();
        ss.close();
    }
}

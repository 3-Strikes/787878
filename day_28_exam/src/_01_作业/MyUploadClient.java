package _01_作业;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class MyUploadClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",8888);
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write(string);
        bw.newLine();
        bw.flush();
        socket.shutdownOutput();
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String s = br.readLine();
        System.out.println("我是客户端,我收到了服务器的响应是:"+s);
        br.close();

        socket.close();
    }
}

package _05_作业;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class HiTcp {
    public static void main(String[] args) throws IOException {
        Socket socket = null;
        try {
            socket = new Socket("127.0.0.1",8888);
            Scanner sc = new Scanner(System.in);
            String str = "Hello TCP";
            OutputStream os = socket.getOutputStream();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
            bw.write(str);
            bw.newLine();
            bw.flush();


            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String s = br.readLine();
            System.out.println("服务端收到信息并回写："+s);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        socket.close();

    }
}

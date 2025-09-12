package _自己敲的;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class T1Client {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("127.0.0.1",8888);
        OutputStream os = s.getOutputStream();
        InputStream in = s.getInputStream();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));//往服务端写数据用流
        BufferedReader br = new BufferedReader(new InputStreamReader(in));//读服务端传来的数据用流
        Scanner sc = new Scanner(System.in);
        //向服务端写数据
        Thread thread1 = new Thread(()->{
            try {
                while (true) {
                    System.out.println("向服务器端传输的信息为：");
                    String string = sc.nextLine();
                    if("88".equals(string)){

                        break;
                    }
                    bw.write(string+'\n');
                    bw.flush();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        //读服务端返回的数据
        Thread thread2 = new Thread(()->{
            String string1 = null;
            while (true) {
                try {
                    string1 = br.readLine();
                    if(string1.equals("88")){
                        break;
                    }
                    System.out.println("服务器传回的数据为："+string1);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("信息传递成功，服务端返回了一个消息："+string1);
            }
        });
        thread1.start();
        thread2.start();



    }
}

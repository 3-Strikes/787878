package _02_挑战;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class StuServer {
    static List<Student> students = new ArrayList<>();
    public static <e> void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        StuInit();
        System.out.println("服务器等待连接。。。");
        ThreadPoolExecutor pool = new ThreadPoolExecutor(3,3,3, TimeUnit.MINUTES, new ArrayBlockingQueue<>(10),new ThreadPoolExecutor.AbortPolicy());

        while(true){
            Socket socket = serverSocket.accept();
            System.out.println("客户端：" + socket.getInetAddress() + " 已连接，分配线程处理...");
            pool.execute(()-> handleClient(socket));
        }
    }

    private static void handleClient(Socket socket){
        try (
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
             BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream())))
        {
            System.out.println("客户端："+socket.getInetAddress()+"已连接");
            while (true) {
                String command = br.readLine();
                String[] commands = command.split(" ");
                if (commands.length < 2) {
                    bw.write("命令格式错误，请使用：查询 学号 或 排名 课程名\n");
                    bw.flush();
                    continue;
                }

                if("查询".equals(commands[0])){
                    String result = quereStuId(commands[1]);
                    if(result!=null) bw.write(result+'\n');
                    else bw.write("该学号不存在，查询失败！\n");
                    bw.flush();
                } else if ("排名".equals(commands[0])) {

                    List<Student> res = sortScoreByCourseName(commands[1]);
                    if(res==null){
                        bw.write("课程不存在\n");
                    }else {
                        StringBuilder sb = new StringBuilder();
                        sb.append(commands[1]).append("成绩排名：\n");
                        for (int i = 0; i < res.size(); i++) {
                            Student s = res.get(i);
                            sb.append(i + 1).append(". ")
                                    .append(s.getName()).append("(")
                                    .append(s.getId()).append("): ")
                                    .append(s.getCourseScore().get(commands[1])).append("\n");
                        }
                        bw.write(sb.toString());
                        bw.flush();
                    }


                } else if ("exit".equals(command)) {
                    bw.write("已收到退出请求\n");
                    bw.flush();
                    break;
                }else {
                    bw.write("未知命令，请使用：查询 学号 或 排名 课程名\n");
                    bw.flush();
                }
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static List<Student> sortScoreByCourseName(String command) {
        // 检查课程是否存在
        if (students.isEmpty() || !students.get(0).getCourseScore().containsKey(command)) {
            return null;
        }
        List<Student> tmplist = new ArrayList<>(students);
        tmplist.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return Integer.compare(o2.getCourseScore().get(command),o1.getCourseScore().get(command));//获取指定的课程名成绩
            }
        });
        return tmplist;
    }

    private static String quereStuId(String command) {
        try {
            for (Student student : students) {
                if(student.getId()==Integer.parseInt(command)){
                    return student.toString();
                }
            }
        } catch (NumberFormatException e) {
            return "格式错误";
        }
        return null;
    }


    private static void StuInit() {
        // 学生1
        Map<String, Integer> courseMap1 = new HashMap<>();
        courseMap1.put("语文", 99);
        courseMap1.put("数学", 80);
        students.add(new Student(1, "zs", courseMap1));

        // 学生2
        Map<String, Integer> courseMap2 = new HashMap<>();
        courseMap2.put("语文", 85);
        courseMap2.put("数学", 92);
        students.add(new Student(2, "ls", courseMap2));

        // 学生3
        Map<String, Integer> courseMap3 = new HashMap<>();
        courseMap3.put("语文", 78);
        courseMap3.put("数学", 88);
        students.add(new Student(3, "ww", courseMap3));

        // 学生4
        Map<String, Integer> courseMap4 = new HashMap<>();
        courseMap4.put("语文", 95);
        courseMap4.put("数学", 76);
        students.add(new Student(4, "zl", courseMap4));

        // 学生5
        Map<String, Integer> courseMap5 = new HashMap<>();
        courseMap5.put("语文", 88);
        courseMap5.put("数学", 90);
        students.add(new Student(5, "qq", courseMap5));
    }
}

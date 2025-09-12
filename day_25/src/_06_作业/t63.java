package _06_作业;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class t63 {
    public static void main(String[] args) {
        String message = "[2023-10-01 08:30:25] 用户张三执行了操作,登录系统，IP 地址为 192.168.1.100;" +
                "[2023-10-01 09:15:42] 用户李四执行了操作,提交订单，IP 地址为 10.0.0.5;" +
                "[2023-10-01 10:20:18] 用户王五执行了操作,修改密码，IP 地址为 172.16.3.89;";

        String rengxname = "\\[.*?\\] 用户(.*?)执行了操作,(.*?)，IP 地址为 (\\d+\\.\\d+\\.\\d+\\.\\d+)";
        String RENGXNAME = "\\[.*?\\] 用户(.*?)执行了操作,(.*?)，IP 地址为 (\\d+\\.\\d+\\.\\d+\\.\\d+)";
//        "\\[.*?\\] 用户(.*?)执行了操作,(.*?)，IP 地址为 (\\d+\\.\\d+\\.\\d+\\.\\d+)"
//        "\\[.*?\\] 用户(.*?)执行了操作,IP地址为(\\d+\\.\\d+\\.\\d+\\.\\d+)"
//        "\\[.*?\\] 用户(.*?)执行了操作，(.*?),IP 地址为 (\\d+\\.\\d+\\.\\d+\\.\\d+)"
        Pattern pattern = Pattern.compile(rengxname);
        Matcher matcher = pattern.matcher(message);

        while(matcher.find()){
            String username = matcher.group(1);
            String oper = matcher.group(2);
            String ip = matcher.group(3);

            System.out.println(username+oper+ip);
        }


    }
}

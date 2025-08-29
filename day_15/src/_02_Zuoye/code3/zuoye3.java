package _02_Zuoye.code3;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class zuoye3 {
    public static void main(String[] args) {
        LocalDateTime ldt = LocalDateTime.now();
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("请输入下单时间格式（yyyy-MM-dd）");
            System.out.println("按q退出。");
            String s = sc.next();
            if(s.equals("q")){
                break;
            }
            LocalDate ldf_now = LocalDate.now();
            System.out.println("当前时间为:"+ldf_now);
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate ldf_user = LocalDate.parse(s,dateTimeFormatter);
            LocalDate ldf_unavali = ldf_user.plusDays(7);
            System.out.println("用户下单的时间为:"+ldf_user);

            Period period = Period.between(ldf_now,ldf_unavali);
            int judge = period.getDays();
            System.out.println(judge);
            if(judge>0){
                System.out.println("订单有效");
            }else {
                System.out.println("订单无效");
            }


        }
    }
}

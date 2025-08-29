package _01_Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Testsdf {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年M月d日H点m分s秒");
        String starttime ="2020年1月1日0点0分0秒";
        String endtime ="2020年1月1日0点10分0秒";

        String jiatime ="2020年1月1日0点3分33秒";
        String pitime ="2020年1月1日0点10分30秒";

        long sttime = sdf.parse(starttime).getTime();
        long edtime =sdf.parse(endtime).getTime();

        long jjtime =sdf.parse(jiatime).getTime();
        long pptime =sdf.parse(pitime).getTime();

        System.out.println(jjtime>=sttime&&jjtime<=edtime?"jj秒杀成功":"jj秒杀失败");
        System.out.println(pptime>=sttime&&pptime<=edtime?"pp秒杀成功":"pp秒杀失败");

    }
}

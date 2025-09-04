package _04_ZUOYE;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiConsumer;

public class zuoye2 {
    public static void main(String[] args) {
        HashMap<String,HashMap<String,Integer>> map =new HashMap<>();


        while(true){
            Scanner sc = new Scanner(System.in);
            String s = sc.nextLine();
            if(s.equals("exit")){
                break ;
            }
            List<String> list = new ArrayList<>();
            HashMap<String,Integer> hashMap = new HashMap<>();//用来存课程和成绩的
            list.addAll(List.of(s.split(" ")));
            System.out.println(list);


//            if(map.containsKey(list.get(0))){
//                map.get(list.get(0)).replace(list.get(1), Integer.valueOf(list.get(2)));
//            }else{
//                hashMap.put(list.get(1), Integer.valueOf(list.get(2)));
//                map.put(list.get(0),hashMap);
//            }

            // 处理学生信息
            if (map.containsKey(list.get(0))) {
                // 学生存在，获取其课程成绩Map
                HashMap<String, Integer> courseMap = map.get(list.get(0));
                // 添加或更新课程成绩
                courseMap.put(list.get(1), Integer.valueOf(list.get(2)));
            } else {
                // 学生不存在，创建新的课程成绩Map
                HashMap<String, Integer> courseMap = new HashMap<>();
                courseMap.put(list.get(1), Integer.valueOf(list.get(2)));
                map.put(list.get(0), courseMap);
            }
        }
        map.forEach(new BiConsumer<String, HashMap<String, Integer>>() {
            @Override
            public void accept(String s, HashMap<String, Integer> stringIntegerHashMap) {
                System.out.println("学生姓名为："+s);
                stringIntegerHashMap.forEach(new BiConsumer<String, Integer>() {
                    @Override
                    public void accept(String s, Integer integer) {
                        System.out.println("课程名："+s+" 成绩："+integer);
                    }
                });
            }
        });


    }
}

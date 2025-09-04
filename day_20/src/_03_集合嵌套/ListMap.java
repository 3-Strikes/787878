package _03_集合嵌套;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

public class ListMap {
    public static void main(String[] args) {
        List<Map<Integer,String>> list = new ArrayList<>();
        Map<Integer,String> map1 = new HashMap<>();
        map1.put(2123,"shabi");
        map1.put(123,"xingqiu");
        map1.put(12,"saodjao");
        list.add(map1);
        Map<Integer,String> map2 = new HashMap<>();
        map1.put(2221,"shabi2");
        map1.put(1111123,"xingqiu2");
        map1.put(132,"saodjao2");
        list.add(map2);
        Map<Integer,String> map3 = new HashMap<>();
        map1.put(2123123123,"shabi3");
        map1.put(121233,"xingqiu3");
        map1.put(11233212,"saodjao3");
        list.add(map3);

        for (Map<Integer, String> map : list) {
            map.forEach(new BiConsumer<Integer, String>() {
                @Override
                public void accept(Integer integer, String s) {
                    System.out.println(integer+"====>"+s);
                }
            });
        }

    }
}

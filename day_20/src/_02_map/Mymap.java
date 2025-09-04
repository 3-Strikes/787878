package _02_map;

import java.util.HashMap;
import java.util.Map;

public class Mymap {
    public static void main(String[] args) {
        HashMap<Integer, String> Sites = new HashMap<Integer, String>();
        // 添加键值对
        Sites.put(1, "Google");
        Sites.put(2, "Runoob");
        Sites.put(3, "Taobao");
        Sites.put(4, "Zhihu");
        // 输出 key 和 value
        for (Integer i : Sites.keySet()) {
            System.out.println("key: " + i + " value: " + Sites.get(i));
        }
        // 返回所有 value 值
        for(String value: Sites.values()) {
            // 输出每一个value
            System.out.print(value + ", ");
        }
        System.out.println();
        for (Map.Entry<Integer,String> entry: Sites.entrySet()){
            System.out.println("key:"+entry.getKey()+"  value:"+entry.getValue());
        }

        Sites.forEach((key,value) ->{
            System.out.println("key:"+key+"  value:"+value);
        });

    }
}

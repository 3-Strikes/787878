package _集合练习;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListDemo {
    public static void main(String[] args) {
        //创建集合（）
        ArrayList<String> list = new ArrayList<>();

        //添加元素
        list.add("apple");
        list.add("banana");
        list.add(1,"Orange");

        //获取元素
        String first = list.get(0);

        list.set(2,"Grape");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        for(String fruit:list){
            System.out.println(fruit);
        }

        for(Iterator<String> it = list.iterator();it.hasNext();){
            String fruit = it.next();
            if(fruit.equals("banana")){
                it.remove();
            }
        }
//        list.contains("apple");
//        list.indexOf("Grape");
//        list.remove(0);
//        list.clear();
    }
}

package _02_map;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.function.BiConsumer;

public class mapex {
    public static void main(String[] args) {
        HashMap<Character,Integer> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            Integer orDefault = map.getOrDefault(key,0);
            map.put(key,++orDefault);
        }
        System.out.println(map);
        Collection<Integer> values = map.values();
        Integer max = Collections.max(values);

        System.out.println(max);

        map.forEach(new BiConsumer<Character, Integer>() {
            @Override
            public void accept(Character character, Integer integer) {
                if(integer==max){
                    System.out.println(character+"====>"+integer);
                }
            }
        });


    }
}

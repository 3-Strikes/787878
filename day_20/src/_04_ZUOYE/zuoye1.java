package _04_ZUOYE;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiConsumer;

public class zuoye1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        List<String> strings = new ArrayList<>();
        strings.addAll(List.of(s.split(" ")));

        System.out.println(strings);
        HashMap<String,Integer> map = new HashMap<>();

        for (int i = 0; i < strings.size(); i++) {
            String key = strings.get(i);
            Integer ordefault = map.getOrDefault(key,0);
            map.put(key,++ordefault);
        }

        map.forEach(new BiConsumer<String, Integer>() {
            @Override
            public void accept(String s, Integer integer) {
                System.out.println(s+"出现了"+integer+"次");
            }
        });



    }
}

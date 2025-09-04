package _01_集合联系;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class myColl {
    public static void main(String[] args) {
        Collection<String> coll = new ArrayList<>();
        coll.add("张三");
        coll.add("李四");
        coll.add("王五");
        coll.add("张三");
        System.out.println(coll);

        coll.removeIf(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return "张三".equals(s);
            }
        });

        System.out.println(coll);

        System.out.println(coll.contains("张三"));
//        coll.clear();

        List<Integer> list = new ArrayList<>();
        Collections.addAll(list,5,213,12,3,4,5,6,7,10);
        Collections.sort(list);
        System.out.println(list);
        Collections.shuffle(list);
        System.out.println(list);
    }
}

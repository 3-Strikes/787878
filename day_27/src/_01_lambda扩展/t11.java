package _01_lambda扩展;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class t11 {
    public static void main(String[] args) {
        List<Double> list = new ArrayList<>(List.of(3.5,2.1,432.4,2.0,1.1,45.3,2.4));
//        Collections.sort(list, new Comparator<Double>() {
//            @Override
//            public int compare(Double o1, Double o2) {
//                return Double.compare(o2,o1);
//            }
//        });

        Collections.sort(list,(o1,o2)->Double.compare(o2,o1));
        System.out.println(list);

        list.forEach(s->System.out.println(s+"-------"));
        list.forEach(System.out::println);
    }
}

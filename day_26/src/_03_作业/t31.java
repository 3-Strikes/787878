package _03_作业;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class t31 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list,"apple", "banana", "orange", "grape", "watermelon");

        Stream<String> stream = list.stream();
        List<String> collect = stream.filter(s -> s.length() > 5).map(String::toUpperCase).collect(Collectors.toList());

        System.out.println(collect);

    }
}

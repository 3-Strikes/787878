package _02_Stream流;

import java.util.List;
import java.util.stream.Stream;

public class t22 {
    public static void main(String[] args) {
        List<Integer> list = List.of(21,321,321,321,321,321,5462633,7,67,67,65);
        Stream<Integer> stream = list.stream();
        Stream<Integer> stream1 = stream.filter(s->s>=300);
        stream1.filter(s->s%2==1).forEach(s-> System.out.println(s));
    }
}

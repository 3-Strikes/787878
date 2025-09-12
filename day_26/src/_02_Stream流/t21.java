package _02_Stream流;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class t21 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list,2,413,314,314,134,314,134,1);

        Stream<Integer> stream = list.stream();

        stream.forEach(s-> System.out.println(s));

        int[] arr = {1,4,7,2,5,8};
        Integer[] arr2 = {1,4,7,2,5,8};

        IntStream stream1 = Arrays.stream(arr);
        stream1.forEach(s-> System.out.println(s));
        System.out.println("------------------");

        Stream<Integer> integerStream = Stream.of(2,5,8,3,6,9);
        integerStream.forEach(s-> System.out.println(s));
        System.out.println("----------------------");


        Stream.of(arr).forEach(y-> System.out.println(Arrays.toString(y)));
        Stream.of(arr2).forEach(y-> System.out.println(y));



    }
}

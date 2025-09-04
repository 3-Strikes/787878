package _01_comparator;

import java.util.Arrays;
import java.util.Comparator;

public class Mydou {
    public static void main(String[] args) {
        Double[] arr = {1.1,1.11,1.123,1.23123,2.1};
        Arrays.sort(arr, new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                return Double.compare(o2,o1);
            }
        });

        System.out.println(Arrays.toString(arr));
    }

}

package _02_set;

import java.util.HashSet;
import java.util.Random;

public class set1 {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        int count = 1;
        Random random = new Random();
        while(set.size()<10){
            int i = random.nextInt(0,21);
            System.out.println("第"+count++ +"次循环，添加的是："+i);
            set.add(i);
        }
        System.out.println(set);
    }
}

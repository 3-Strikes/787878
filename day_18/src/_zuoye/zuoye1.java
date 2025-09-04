package _zuoye;

import java.util.ArrayList;
import java.util.List;

public class zuoye1 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(10);
        list.add(12192);
        list.add(11);
        for (int i = 0; i < list.size(); i++) {
            int q = list.get(i);
            if(q>10){
                list.set(i,0);
            }

        }
        System.out.println(list);


    }
}

package _01_ArrayList框架;

import java.util.ArrayList;

public class Test04 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("aa");
        list.add("bb");
        list.add("aa");
        list.add("aa");
        list.add("aa");
        list.add("aa");
        list.add("bdcd");
        System.out.println(list);

        for (int i = list.size() - 1; i >= 0; i--) {
            String ys = "aa";
            if(list.get(i)==ys){
                list.remove(i);//remova后 list的后续自动往前补位
            }
        }

        System.out.println(list);





    }
}

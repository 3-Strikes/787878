package _03_ZUOYE;

import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        List<String> tt = new ArrayList<>();
        tt.add("adada");
        tt.add("adada");
        tt.add("adada");
        tt.add("adada");
        tt.add("adada");
        tt.add("adada");
        tt.add("adada");
        tt.add("adada");
        show(tt);

    }


    public static <T> void show(List<T> list){
        for(T element:list){
            System.out.println(element);
        }
    }
}

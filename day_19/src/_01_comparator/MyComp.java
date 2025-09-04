package _01_comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MyComp {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        Collections.addAll(list,new Student("张三",18)
                ,new Student("LISI",123)
                ,new Student("wangwu",15)
                ,new Student("zhaoliu",188)
                ,new Student("niuqi",10)
        );
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o2.getAge()-o1.getAge();
            }
        });

        System.out.println(list);

        List<String> list1 = new ArrayList<>();
        Collections.addAll(list1,"aa","ab","ac","ae","asd","asdsada","xwq","ea");
        Collections.sort(list1, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int i = o2.length()-o1.length();
                //混合排序 先按长度升序排列 再按字典序排列  用compareTo方法
                return i==0?o1.compareTo(o2):i;
            }
        });

        System.out.println(list1);
    }
}

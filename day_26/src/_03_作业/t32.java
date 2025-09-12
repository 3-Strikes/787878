package _03_作业;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class t32 {
    public static void main(String[] args) {
        String[] strings = {"张三：20", "李四：25", "王五：30", "赵六：35"};
//        Map<String,Integer> map = new HashMap<>();
//
//
//        for (int i = 0; i < strings.length; i++) {
//            String[] s = strings[i].split("：");
//            map.put(s[0], Integer.valueOf(s[1]));
//        }
//        System.out.println(map);
        List<Person> personList = Arrays.stream(strings).map(s->{
            String[] parts = s.split("：");
            String name = parts[0];
            Integer age = Integer.valueOf(parts[1]);
            return new Person(name,age);
        }).filter(person -> person.getAge()>25).collect(Collectors.toList());

        System.out.println("年龄大于25的人：");
        personList.forEach(person -> System.out.println(person));


    }
}
